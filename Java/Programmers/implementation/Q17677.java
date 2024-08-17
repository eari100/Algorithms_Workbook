package Programmers.implementation;

import java.util.HashMap;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/17677 (2018 KAKAO BLIND RECRUITMENT > [1차] 뉴스 클러스터링)
 * @classification: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.17 (O)
 **/
public class Q17677 {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;
        int str1Cnt = 0, str2Cnt = 0, _min = 0, _max = 0;

        for(int i=1;i<str1.length();i++) {
            char prev = str1.charAt(i-1);
            char next = str1.charAt(i);

            if( !isUpperCase(next) ) {
                continue;
            }

            if( !isUpperCase(prev) ) {
                continue;
            }

            String str = "" + prev + next;
            ++str1Cnt;

            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(int i=1;i<str2.length();i++) {
            char prev = str2.charAt(i-1);
            char next = str2.charAt(i);

            if( !isUpperCase(next) ) {
                continue;
            }

            if( !isUpperCase(prev) ) {
                continue;
            }

            String str = "" + prev + next;
            ++str2Cnt;

            if(map.getOrDefault(str, 0) > 0) {
                map.put(str, map.get(str) - 1);
                ++_min;
            }
        }

        _max = str1Cnt + str2Cnt - _min;

        if(_min == 0 && _max == 0) {
            return 65536;
        }

        double d = (double) _min / _max * 65536;
        answer = (int) d;

        return answer;
    }

    private boolean isUpperCase(char c) {
        return 'A' <= c && 'Z' >= c;
    }
}
