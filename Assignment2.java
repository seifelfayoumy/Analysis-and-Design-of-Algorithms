import java.util.HashMap;
import java.util.Map;

public class Assignment2 {
	static String x;
	static String y;
	static double[][] scoreMatrix;
	
    public static void main(String args[]) {
        x = "TCCCAGTTATGTCAGGGGACACGAGCATGCAGAGAC";
        y = "AATTGCCGCCGTCGTTTTCAGCAGTTATGTCAGATC";
        scoreMatrix = new double[][]{
            {1, -0.8, -0.2, -2.3, -0.6},
            {-0.8, 1, -1.1, -0.7, -1.5},
            {-0.2, -1.1, 1, -0.5, -0.9},
            {-2.3, -0.7, -0.5, 1, -1},
            {-0.6, -1.5, -0.9, -1, 0} // Assuming gap vs gap score is 0
        };

        double score = sequenceAlignment(x, y, scoreMatrix);
        System.out.println("Highest-scoring alignment: " + score);
    }

    private static double sequenceAlignment(String x, String y, double[][] scoreMatrix) {
        int m = x.length();
        int n = y.length();
        double[][] dp = new double[m+1][n+1];
        Map<Character, Integer> charIndexMap = createCharIndexMap(x + y);

        // Initialize the first column and row
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + scoreMatrix[charIndexMap.get(x.charAt(i-1))][4];
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] + scoreMatrix[4][charIndexMap.get(y.charAt(j-1))];
        }

        // Fill the DP matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                double match = dp[i-1][j-1] + scoreMatrix[charIndexMap.get(x.charAt(i-1))][charIndexMap.get(y.charAt(j-1))];
                double delete = dp[i-1][j] + scoreMatrix[charIndexMap.get(x.charAt(i-1))][4];
                double insert = dp[i][j-1] + scoreMatrix[4][charIndexMap.get(y.charAt(j-1))];
                dp[i][j] = Math.max(match, Math.max(delete, insert));
            }
        }

//        printDpMatrix(dp);
        printAlignedSequences(x, y, dp, charIndexMap);
        return dp[m][n];
    }

    private static Map<Character, Integer> createCharIndexMap(String sequence) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (char c : sequence.toCharArray()) {
            if (!map.containsKey(c) && c != '-') {
                map.put(c, index++);
            }
        }
        map.put('-', index);
        return map;
    }

    private static void printDpMatrix(double[][] dp) {
        for (double[] row : dp) {
            for (double cell : row) {
                System.out.printf("%6.2f ", cell);
            }
            System.out.println();
        }
    }

    private static void printAlignedSequences(String x, String y, double[][] dp, Map<Character, Integer> charIndexMap) {
        StringBuilder alignX = new StringBuilder();
        StringBuilder alignY = new StringBuilder();
        int i = x.length();
        int j = y.length();

        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && dp[i][j] == dp[i-1][j-1] + scoreMatrix[charIndexMap.get(x.charAt(i-1))][charIndexMap.get(y.charAt(j-1))]) {
                alignX.insert(0, x.charAt(i-1));
                alignY.insert(0, y.charAt(j-1));
                i--;
                j--;
            } else if (i > 0 && dp[i][j] == dp[i-1][j] + scoreMatrix[charIndexMap.get(x.charAt(i-1))][4]) {
                alignX.insert(0, x.charAt(i-1));
                alignY.insert(0, '-');
                i--;
            } else if (j > 0) {
                alignX.insert(0, '-');
                alignY.insert(0, y.charAt(j-1));
                j--;
            }
        }

        System.out.println(alignX.toString());
        System.out.println(alignY.toString());
    }
}
