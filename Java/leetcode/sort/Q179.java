package leetcode.sort;

import java.util.Arrays;

/**
 *@source: https://leetcode.com/problems/largest-number/?envType=daily-question&envId=2024-09-18 (179. Largest Number)
 *@classfication: sort
 * @문제 푼 날짜 (자력으로 풂?): X
 **/
public class Q179 {
    public String largestNumber(int[] nums) {
        StringBuilder result = new StringBuilder();
        String[] strNums = new String[nums.length];

        for(int i=0;i<nums.length;i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        if(strNums[0].equals("0")) {
            return "0";
        }

        for(int i=0;i<strNums.length;i++) {
            result.append(strNums[i]);
        }

        return result.toString();
    }
}
