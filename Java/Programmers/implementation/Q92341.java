package Programmers.implementation;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/92341 (2022 KAKAO BLIND RECRUITMENT > 주차 요금 계산)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.08.24 (O)
 **/
public class Q92341 {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<String, ArrayList<Integer>> prices = new TreeMap<>();

        for(String record : records) {
            String[] data = record.split(" ");
            String time = data[0];
            String[] hourMinutes = time.split(":");
            int hour = Integer.parseInt(hourMinutes[0]);
            int minutes = Integer.parseInt(hourMinutes[1]);
            int t = hour * 60 + minutes;

            String carNumber = data[1];
            String inOrOut = data[2];

            if(prices.containsKey(carNumber)) {
                ArrayList<Integer> list = prices.get(carNumber);
                list.add(t);
                prices.put(carNumber, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(t);
                prices.put(carNumber, list);
            }
        }

        int basicTime = fees[0], basicPrice = fees[1];
        int unitTime = fees[2], unitPrice = fees[3];
        int[] answer = new int[prices.size()];

        Map.Entry<String, ArrayList<Integer>>[] entries = prices.entrySet().toArray(new Map.Entry[0]);
        for (int i = 0; i < entries.length; i++) {
            Map.Entry<String, ArrayList<Integer>> entry = entries[i];
            ArrayList<Integer> list = entry.getValue();

            if(list.size() % 2 == 1) {
                list.add(23 * 60 + 59);
            }

            for(int j=1;j<list.size();j+=2) {
                int prev = list.get(j-1);
                int next = list.get(j);

                answer[i] += next - prev;
            }

            int a = answer[i];
            int result = basicPrice;

            if(a > basicTime) {
                a -= basicTime;
                int bonus = a / unitTime;
                int remain = a % unitTime;

                if(remain > 0) {
                    ++bonus;
                }

                result += bonus * unitPrice;
            }

            answer[i] = result;
        }

        return answer;
    }
}
