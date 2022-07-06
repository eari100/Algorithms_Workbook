package leetcode.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: https://leetcode.com/problems/queue-reconstruction-by-height/ (Queue Reconstruction by Height)
 * @classfication: greedy, sort, linkedList
 * @reference: https://leetcode.com/problems/queue-reconstruction-by-height/discuss/2211641/Visual-Explanation-or-JAVA-Greedy (그림으로 쉽게 설명)
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.07 (X)
 **/
public class Q406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> ordered = new LinkedList<>();
        for (int[] p: people) ordered.add(p[1], p);

        return ordered.toArray(new int[people.length][2]);
    }
}
