package Programmers.implementation;

import java.util.*;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/150370 (2023 KAKAO BLIND RECRUITMENT > 개인정보 수집 유효기간)
 * @classification: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.11 (O)
 **/
// todo: 업솔빙 (날짜 처리 실수를 오랫동안 찾음)
public class Q150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] todayYmd = Arrays.stream(today.split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayList<Integer> diposeList = new ArrayList<>();
        HashMap<String, Integer> codition = new HashMap<>();

        for(String term : terms) {
            String[] data = term.split(" ");
            String type = data[0];
            int period = Integer.parseInt(data[1]);

            codition.put(type, period);
        }

        for(int i=0;i<privacies.length;i++) {
            String privacy = privacies[i];
            String[] data = privacy.split(" ");
            String date = data[0], coditionType = data[1];
            int[] ymd = Arrays.stream(date.split("\\."))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int period = codition.get(coditionType);
            int sum = ymd[1] + period;

            int year2 = ymd[0] + (sum / 12);

            if(sum % 12 == 0) {
                --year2;
            }

            int month2 = sum % 12 == 0 ? 12 : sum % 12;
            int day2 = 0;

            if(ymd[2] - 1 == 0) {
                --month2;
                if(month2 == 0) {
                    month2 = 12;
                    --year2;
                }

                day2 = 28;
            } else {
                day2 = ymd[2] - 1;
            }

            int[] resultYmd = new int[]{year2, month2, day2};
            System.out.println(Arrays.toString(resultYmd));

            for(int j=0;j<3;j++) {
                int r = resultYmd[j], t = todayYmd[j];

                if(r == t) continue;

                if(r < t) {
                    diposeList.add(i+1);
                }

                break;
            }
        }

        int[] answer = new int[diposeList.size()];

        for(int i=0;i<diposeList.size();i++) {
            answer[i] = diposeList.get(i);
        }

        return answer;
    }
}
