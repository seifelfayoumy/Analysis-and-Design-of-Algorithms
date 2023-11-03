import matplotlib.pyplot as plt
import numpy as np
import time

# Naïve Iterative Method
def naive_power(a, n):
    """
    Computes a^n using a naïve iterative method.
    Asymptotic Time Complexity: Θ(n)
    """
    result = 1
    for _ in range(n):
        result *= a
    return result

# Divide-and-Conquer Approach for Powering
def divide_and_conquer_power(a, n):
    """
    Computes a^n using a divide-and-conquer approach.
    Asymptotic Time Complexity: Θ(log n)
    Recurrence Relation: T(n) = T(n/2) + Θ(1)
    Recurrence Solution: T(n) = Θ(log n) via the Master Theorem or by recursive tree method.
    """
    if n == 0:
        return 1
    elif n % 2 == 0:
        half_power = divide_and_conquer_power(a, n // 2)
        return half_power * half_power
    else:
        half_power = divide_and_conquer_power(a, n // 2)
        return a * half_power * half_power

# Merge Sort
def merge_sort(arr):
    """
    Sorts an array using the merge sort algorithm.
    Asymptotic Time Complexity: Θ(n log n)
    Recurrence Relation: T(n) = 2T(n/2) + Θ(n)
    Recurrence Solution: T(n) = Θ(n log n) via the Master Theorem or by recursive tree method.
    """
    if len(arr) > 1:
        mid = len(arr) // 2
        L = arr[:mid]
        R = arr[mid:]

        merge_sort(L)
        merge_sort(R)

        i = j = k = 0
        while i < len(L) and j < len(R):
            if L[i] < R[j]:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1

        while i < len(L):
            arr[k] = L[i]
            i += 1
            k += 1

        while j < len(R):
            arr[k] = R[j]
            j += 1
            k += 1

# Binary Search
def binary_search(arr, x):
    """
    Implements binary search to find the index of x in arr if present, else returns -1.
    Asymptotic Time Complexity: Θ(log n)
    """
    low, high = 0, len(arr) - 1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == x:
            return mid
        elif arr[mid] < x:
            low = mid + 1
        else:
            high = mid - 1
    return -1

# Finding Pairs with Given Sum using Binary Search
def find_pairs_with_sum_binary_search(arr, target_sum):
    """
    Finds all pairs in a sorted array that sum up to target_sum.
    Utilizes binary search technique.
    Asymptotic Time Complexity: Θ(n log n)
    """
    pairs = []
    for i in range(len(arr)):
        complement = target_sum - arr[i]
        if binary_search(arr, complement) != -1:
            pairs.append((arr[i], complement))
    return pairs

# Test Function for Finding Pairs with Given Sum
def test_find_pairs_algorithm(n):
    """
    Tests the find_pairs_with_sum_binary_search function for scalability.
    Overall Asymptotic Time Complexity: Θ(n log n) due to the merge sort and binary search.
    """
    arr = generate_random_array(n)
    target_sum = 100
    merge_sort(arr)
    return measure_time(find_pairs_with_sum_binary_search, arr, target_sum)

# Measure Time Function
def measure_time(func, *args):
    """
    Measures the time taken by a function to execute.
    """
    start_time = time.time()
    func(*args)
    return (time.time() - start_time) * 1000  # Convert to milliseconds

# Generate Random Array
def generate_random_array(n):
    """
    Generates a random array of size n with values between 1 and 100.
    """
    return np.random.randint(1, 100, n).tolist()

# Values of n to test
n_values = np.array([1, 10, 100, 1000, 10000, 100000, 1000000], dtype=np.int)

# Measure times for each algorithm
naive_times = [measure_time(naive_power, 2, n) for n in n_values]
divide_and_conquer_times = [measure_time(divide_and_conquer_power, 2, n) for n in n_values]
find_pairs_times = [test_find_pairs_algorithm(n) for n in n_values]

# Plotting
plt.figure(figsize=(10, 6))
plt.loglog(n_values, naive_times, '-o', label='Naive Iterative')
plt.loglog(n_values, divide_and_conquer_times, '-o', label='Divide and Conquer')
plt.loglog(n_values, find_pairs_times, '-o', label='Find Pairs with Binary Search')
plt.xlabel('n')
plt.ylabel('Time (milliseconds)')
plt.title('Algorithm Performance')
plt.legend()
plt.grid(True)
plt.savefig("algorithm_performance.png")
plt.show()
