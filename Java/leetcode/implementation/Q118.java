package leetcode.implementation;

import java.util.*;

/**
 * @source: https://leetcode.com/problems/pascals-triangle/ (Pascal's Triangle)
 * @classfication: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.19 (O)
 **/
public class Q118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> oneLine = new ArrayList<>();
        oneLine.add(1);
        triangle.add(oneLine);

        for(int i=1;i<numRows;i++) {
            List<Integer> prev = triangle.get(i-1);
            List<Integer> line = new ArrayList<>();

            for(int j=0;j<i+1;j++) {
                if(j==0 || j==i) {
                    line.add(1);
                } else {
                    int sum = prev.get(j-1) + prev.get(j);
                    line.add(sum);
                }
            }

            triangle.add(line);
        }

        return triangle;
    }
}
