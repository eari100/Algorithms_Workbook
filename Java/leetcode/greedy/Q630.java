package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @source: https://leetcode.com/problems/course-schedule-iii/ (630. Course Schedule III)
 * @classfication: priority queue + greedy
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.24 (X)
 **/
public class Q630 {
    public int scheduleCourse(int[][] courses) {
        var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));

        for (int i = 0, total = 0; i < courses.length; i++) {
            maxHeap.add(courses[i][0]);
            if ((total += courses[i][0]) > courses[i][1])
                total -= maxHeap.poll();
        }
        return maxHeap.size();
    }
}
