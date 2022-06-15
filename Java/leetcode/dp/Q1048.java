package leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @source: https://leetcode.com/problems/longest-string-chain/submissions/
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.15 (X, 해시)
 **/
public class Q1048 {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }
}
