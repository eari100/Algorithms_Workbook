package leetcode.dp;

/**
 * @source: https://leetcode.com/problems/delete-operation-for-two-strings/
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.15 (X)
 **/
public class Q583 {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i = 1; i <= word1.length(); i++)
            for(int j = 1; j <= word2.length(); j++)
                dp[i][j] = word1.charAt(i-1) == word2.charAt(j-1) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}
