package leetcode.caching;

/**
 * @source: https://leetcode.com/problems/maximum-product-of-word-lengths/ (304. Range Sum Query 2D - Immutable)
 * @classfication: caching
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.03 (X)
 **/
public class Q304 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            new int[]{3, 0, 1, 4, 2},
            new int[]{5, 6, 3, 2, 1},
            new int[]{1, 2, 0, 1, 5},
            new int[]{4, 1, 0, 1, 7},
            new int[]{1, 0, 3, 0, 5}
        };

        Q304 q304 = new Q304(matrix);
        System.out.println(q304.sumRegion(2, 1, 4, 3));
        System.out.println(q304.sumRegion(1, 1, 2, 2));
        System.out.println(q304.sumRegion(1, 2, 2, 4));
    }

    private int[][] dp;

    public Q304(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r][c + 1] = dp[r][c] + matrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            sum += dp[row][col2 + 1] - dp[row][col1];
        }
        return sum;
    }
}
