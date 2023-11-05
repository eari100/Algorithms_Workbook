package Programmers.hash;

import java.util.*;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/138476 (귤 고르기)
 * @classification: hash
 * @문제 푼 날짜 (자력으로 풂?): 23.11.05 (O)
 **/
public class Q138476 {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int answer = 0;
        int totalCnt = tangerine.length;
        int excludeCnt = totalCnt - k;

        for(int t : tangerine) {
            int val = hm.getOrDefault(t, 0) + 1;
            hm.put(t, val);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(hm.entrySet());
        Collections.sort(entryList, (h1, h2) -> h1.getValue() - h2.getValue());

        for(Map.Entry<Integer, Integer> entry : entryList) {
            int val = entry.getValue();

            if(excludeCnt > 0) {
                if(excludeCnt >= val) {
                    excludeCnt -= val;
                } else {
                    excludeCnt = 0;
                    ++answer;
                }
            } else {
                ++answer;
            }
        }

        return answer;
    }
}
