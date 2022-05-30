package leetcode.dataType;

/**
 * @source: https://leetcode.com/problems/divide-two-integers/ (29. Divide Two Integers)
 * @classfication: data type
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.05.30 (X)
 **/
public class Q29 {
    public int divide(int dividend, int divisor) {
        return dividend==Integer.MIN_VALUE&&divisor==-1 ? Integer.MAX_VALUE : dividend / divisor;
    }
}
