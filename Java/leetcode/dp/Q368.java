package leetcode.dp;

import java.util.*;

/**
 * @source: https://leetcode.com/problems/largest-divisible-subset/description/ (368. Largest Divisible Subset)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.04.13 (X)
 **/
// 조건
// c > b > a
// b % a = 0 (b는 a로 나누어떨어진다)
// c % b = 0 (c는 b로 나누어떨어진다)

// 증명
// b = k * a
// c = m * (k * a)
// c = (m * k) * a
// 고로 c % a = 0
public class Q368 {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> answer = new ArrayList<>();
        int[] prev = new int[nums.length];
        Arrays.fill(prev, -1);
        int[] count = new int[nums.length];
        int last_index = 0;

        for(int i=1;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] % nums[j] == 0 && count[i] < count[j] + 1) {
                    count[i] = count[j] + 1;
                    prev[i] = j;

                    if(count[last_index] < count[i]) {
                        last_index = i;
                    }
                }
            }
        }

        while(last_index >= 0) {
            answer.add(nums[last_index]);
            last_index = prev[last_index];
        }

        return answer;
    }
}
