package leetcode.dataStructure.tree;

import java.util.TreeMap;

/**
 * @source: https://leetcode.com/problems/my-calendar-i/solution/ (My Calendar I)
 * @classfication: treeMap, implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.08.03 (X)
 **/
public class Q729 {
    TreeMap<Integer, Integer> calendar;

    Q729() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
