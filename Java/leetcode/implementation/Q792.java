package leetcode.implementation;

import java.util.HashMap;

/**
 * @source: https://leetcode.com/problems/number-of-matching-subsequences/ (Number of Matching Subsequences)
 * @classfication: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.20 (O)
 **/
public class Q792 {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;

        for(String word : words) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else {
                map.put(word, 1);
            }
        }

        for( String key : map.keySet() ) {
            int match = 0;
            int index = 0;

            for(char w : key.toCharArray()) {
                while(index < s.length()) {
                    if(w == s.charAt(index)) {
                        ++match;
                        ++index;
                        break;
                    }
                    ++index;
                }
            }

            if(match==key.length()) result += map.get(key);
        }

        return result;
    }
}
