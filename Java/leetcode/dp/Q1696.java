package leetcode.dp;

import java.util.LinkedList;

/**
 * @source: https://leetcode.com/problems/jump-game-vi/ (Jump Game VI)
 * @classfication: dp + queue
 * @reference: https://leetcode.com/problems/jump-game-vi/discuss/2256801/JAVA-or-90-faster-or-DP-easy-solution
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.09 (X, 점화식은 웰노운이라 구상 그러나 효율적인 queue 활용법을 생각해내지 못함)
 **/
public class Q1696 {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        LinkedList<Integer> queue = new LinkedList<>();
        dp[0] = nums[0];
        queue.offer(0);

        // dp[n] = nums[i] + max(dp[n-k], ... dp[n-1])
        for(int i=1;i<nums.length;i++) {
            if(queue.getFirst() < i-k) {
                queue.removeFirst();
            }

            dp[i] = dp[queue.getFirst()] + nums[i];

            while(!queue.isEmpty() && dp[queue.getLast()] <= dp[i]) {
                queue.removeLast();
            }

            queue.offer(i);
        }

        return dp[dp.length-1];
    }
}
