package leetcode.dp;

import java.util.List;

/**
 * @source: https://leetcode.com/problems/triangle
 * @classfication: dynamic programming
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.13 (O, 별도의 메모리 공간을 만들지 않아서 수행시간이 떨어진다. 나중에 코드 수정하자.)
 **/
public class Q120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // dp[i, j] = min(dp[i+1, j], dp[i+1, j+1])

        for(int i=triangle.size()-2;i>=0;i--) {
            for(int j=0;j<triangle.get(i).size();j++) {
                triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }

        return triangle.get(0).get(0);
    }
}
