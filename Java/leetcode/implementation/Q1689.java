package leetcode.implementation;

import java.util.Arrays;

/**
 * @source: https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/submissions/ (Partitioning Into Minimum Number Of Deci-Binary Numbers)
 * @classfication: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.06.27 (O, Runtime: 482 ms, faster than 5.02% Memory Usage: 115.6 MB, less than 5.02%)
 **/
public class Q1689 {
    public int minPartitions(String n) {
        String[] arr = n.split("");
        Arrays.sort(arr);
        return Integer.parseInt(arr[n.length()-1]);
    }
}
