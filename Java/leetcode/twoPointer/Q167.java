package leetcode.twoPointer;

/**
 * @source: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * @classfication: two pointer
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.09 (O)
 **/
public class Q167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int[] result = new int[2];

        while(left < right) {
            int sum = numbers[left] + numbers[right];

            if(sum == target) {
                result = new int[]{left+1, right+1};
                break;
            } else if(sum < target) {
                ++left;
            } else {
                --right;
            }
        }

        return result;
    }
}
