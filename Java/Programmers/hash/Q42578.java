package Programmers.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=java (의상)
 * @classification: hash, math
 * @문제 푼 날짜 (자력으로 풂?): 23.10.16 (O)
 **/
public class Q42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String[] c : clothes) {
            String type = c[1];
            hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
        }

        for(Map.Entry<String, Integer> entrySet : hashMap.entrySet()) {
            answer *= entrySet.getValue() + 1;
        }

        return answer - 1;
    }
}
