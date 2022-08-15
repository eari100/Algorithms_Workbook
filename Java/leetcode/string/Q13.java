package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 *@source: https://leetcode.com/problems/roman-to-integer/submissions/ (Roman to Integer)
 *@classfication: string
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.08.15 (O, Runtime: 11 ms, faster than 45.05% Memory Usage: 47.1 MB, less than 21.52%)
 **/
public class Q13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = map.get(s.charAt(0));

        for(int i=1;i<s.length();i++) {
            int x = map.get(s.charAt(i));
            int y = map.get(s.charAt(i-1));

            num += x;
            if(x > y) num -= (2*y);
        }

        return num;
    }
}
