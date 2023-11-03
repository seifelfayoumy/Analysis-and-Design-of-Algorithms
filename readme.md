# Algorithm Analysis and Design Report

## Introduction
The objective of this assignment is to apply algorithm analysis and design techniques learned in the course. It involves implementing specific algorithms, analyzing their theoretical time complexities, and verifying these complexities through empirical experiments.

## Problem 1: Powering a Number
### 1.1 Algorithms Implemented
- **Naïve Iterative Method**: A straightforward approach with linear time complexity.
- **Divide and Conquer Power**: An efficient recursive method with logarithmic time complexity.

### 1.2 Theoretical Analysis
- Naïve Method: Θ(n)
- Divide and Conquer Power: Θ(log n)

### 1.3 Empirical Analysis
The execution times of both the naïve iterative method and the divide-and-conquer approach were measured across various input sizes (1 to 10^6). The results are included in the performance plot (see Figure 1).



### 1.4 Discussion
The empirical results confirm the theoretical analysis, showing that the divide-and-conquer approach is significantly faster for large inputs.

## Problem 2: Finding Pairs with Given Sum
### 2.1 Algorithms Implemented
- **Merge Sort**: Utilized for sorting the set of integers with a time complexity of Θ(n log n).
- **Binary Search for Pairs**: Applied to find pairs with a given sum in the sorted set. Time complexity of Θ(log n).

### 2.2 Theoretical Analysis
- Merge Sort: Θ(n log n)
- Binary Search for Pairs: Θ(log n)

### 2.3 Empirical Analysis
The execution times for finding pairs were measured across various input sizes (1 to 10^6). The results are also included in the performance plot (see Figure 1).

![Figure 1: Execution Times for Algorithms](algorithm_performance.png)

### 2.4 Discussion
The empirical results align well with the theoretical predictions, showcasing the efficiency of the divide-and-conquer paradigm.

## Conclusion
The assignment successfully demonstrates the practical application of algorithm analysis and design principles. The divide-and-conquer strategies proved to be highly efficient for the problems addressed, confirming the theoretical analyses.