package Programmers.LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/17680 ([1차] 캐시)
 * @classfication: LRU
 * @문제 푼 날짜 (자력으로 풂?): 24.03.16 (O)
 **/
public class Q17680 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        final int cacheHit = 1, cacheMiss = 5;
        HashMap<String, Integer> caches = new HashMap<>(); // 도시, 최근 호출 순서

        for(int i=0;i<cities.length;i++) {
            String city = cities[i].toLowerCase();

            if(caches.containsKey(city)) {
                answer += cacheHit;
                caches.put(city, i);
            } else {
                answer += cacheMiss;
                caches.put(city, i);

                if(caches.size() > cacheSize) {

                    String latelyCity = city;
                    int latelyOrder = i;

                    for(Map.Entry<String, Integer> cache : caches.entrySet()) {
                        String city2 = cache.getKey();
                        int order = cache.getValue();

                        if(latelyOrder > order) {
                            latelyOrder = order;
                            latelyCity = city2;
                        }
                    }

                    caches.remove(latelyCity);
                }
            }
        }

        return answer;
    }
}
