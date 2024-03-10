package Programmers.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/131127 (할인 행사)
 * @classification: hash + sliding-window
 * @문제 푼 날짜 (자력으로 풂?): 24.03.10 (O)
 **/
public class Q131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hashWant = initHashWant(want, number);
        HashMap<String, Integer> hashDisc = initHashDiscount(discount);

        if(isMatching(hashWant, hashDisc)) {
            ++answer;
        }

        for(int i=1;i<discount.length-9;i++) {
            int prevI = i-1;
            String prev = discount[prevI];
            hashDisc.put(prev, hashDisc.get(prev) - 1);

            int currI = i+9;
            String curr = discount[currI];
            hashDisc.put(curr, hashDisc.getOrDefault(curr, 0) + 1);

            if(isMatching(hashWant, hashDisc)) {
                ++answer;
            }
        }

        return answer;
    }

    private HashMap<String, Integer> initHashWant(String[] want, int[] number) {
        HashMap<String, Integer> hashWant = new HashMap<>();

        for(int i=0;i<want.length;i++) {
            String w = want[i];
            int n = number[i];

            hashWant.put(w, n);
        }

        return hashWant;
    }

    private HashMap<String, Integer> initHashDiscount(String[] discount) {
        HashMap<String, Integer> hashDisc = new HashMap<>();

        for(int i=0;i<10;i++) {
            String disc = discount[i];
            hashDisc.put(disc, hashDisc.getOrDefault(disc, 0) + 1);
        }

        return hashDisc;
    }

    private boolean isMatching(HashMap<String, Integer> hashWant, HashMap<String, Integer> hashDisc) {
        for(Map.Entry<String, Integer> entry : hashDisc.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if( !Objects.equals(value, hashWant.getOrDefault(key, 0)) ) {
                return false;
            }
        }

        return true;
    }
}
