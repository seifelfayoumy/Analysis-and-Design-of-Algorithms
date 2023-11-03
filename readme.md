# Algorithm Performance Analysis Report

## Introduction
This document briefly summarizes the implementation and analysis of several algorithms, focusing on their theoretical and empirical performance.

## Algorithms Implemented
1. **Naive Iterative Method**: Simple method for calculating powers. Linear time complexity.
2. **Divide and Conquer Power**: An efficient method for calculating powers with logarithmic time complexity.
3. **Merge Sort**: Used for sorting arrays with optimal time complexity of Θ(n log n).
4. **Binary Search for Pairs**: Finds pairs in a sorted array that sum up to a target number. Logarithmic time complexity.

## Theoretical Analysis
- Naive Method: Θ(n)
- Divide and Conquer Power: Θ(log n)
- Merge Sort: Θ(n log n)
- Binary Search for Pairs: Θ(log n)

## Empirical Analysis
Execution times were measured for each algorithm across various input sizes. Graphs illustrating these measurements are included (see `algorithm_performance.png`). The empirical results align with the theoretical complexities.

## Conclusion
The assignment demonstrates the effectiveness of divide-and-conquer strategies over simpler iterative methods, especially for larger inputs.

## References
- Cormen, T. H., et al. "Introduction to Algorithms."
- Sedgewick, R., & Wayne, K. "Algorithms."
