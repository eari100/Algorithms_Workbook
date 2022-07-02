package leetcode.greedy;

import java.util.Arrays;

/**
 * @source: https://leetcode.com/problems/maximum-units-on-a-truck/ (Maximum Units on a Truck)
 * @classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.02 (O)
 **/
public class Q1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (b1, b2) -> b2[1] - b1[1]);

        int result = 0;
        for(int[] boxType : boxTypes) {
            if(truckSize >= boxType[0]) {
                result += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                result += truckSize * boxType[1];
                break;
            }
        }

        return result;
    }
}
