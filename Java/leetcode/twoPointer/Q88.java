package leetcode.twoPointer;

/**
 * @source: https://leetcode.com/problems/merge-sorted-array/
 * @classfication: two pointer
 * @reference:
 * 1. two pointer: https://leetcode.com/problems/merge-sorted-array/discuss/29704/My-clean-java-solution
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.05.27 (O, 단순구현)
 **/
public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2, if any
            nums1[finished--] = nums2[tail2--];
        }
    }
}
