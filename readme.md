# Assignment 2 Report

### Implementation Details

In the provided algorithm, dynamic programming is utilized to efficiently solve the sequence alignment problem, essential in comparing genetic sequences. By constructing a matrix where each cell represents the optimal alignment score up to that point, the algorithm systematically calculates the highest-scoring alignment between two sequences. This approach leverages the overlapping subproblems inherent in sequence alignment, ensuring a thorough and optimal comparison with a time complexity of \(O(mn)\), where \(m\) and \(n\) are the lengths of the two sequences.

The algorithm, implemented in Java, systematically fills a 2D dynamic programming (DP) matrix, where each element represents the best alignment score between substrings of the input sequences. Key steps include initializing the first row and column based on gap penalties and iteratively computing each cell’s score by considering matches, mismatches, and gaps. The solution is generalized to handle any character set in the sequences, enhancing its applicability. The final output includes both the optimal alignment score and the aligned sequences themselves, obtained through a traceback process.

### Time Complexity Analysis

The time complexity of this sequence alignment algorithm is \(O(mn)\), where \(m\) and \(n\) are the lengths of the two input sequences. This efficiency arises because each cell in the \(m \times n\) DP matrix is computed exactly once, with each computation involving a constant amount of work. The algorithm's design ensures that all necessary sub-solutions are computed and stored, eliminating redundant calculations. This efficiency makes it particularly suitable for aligning long genetic sequences frequently encountered in bioinformatics.
