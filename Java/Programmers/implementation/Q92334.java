package Programmers.implementation;

import java.util.HashMap;
import java.util.HashSet;

/**
 *@source: https://programmers.co.kr/learn/courses/30/lessons/92334 (신고 결과 받기)
 *@classfication: implementation
 **/
public class Q92334 {
    public static void main(String[] args) {
        Q92334 s = new Q92334();
        s.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> prettyReport = new HashMap<>();

        HashMap<String, Integer> repCnt = new HashMap<>();
        for(int i=0;i<id_list.length;i++) {
            repCnt.put(id_list[i], 0);
            prettyReport.put(id_list[i], new HashSet<>());
        }


        for(String s : report) {
            String[] data = s.split(" ");
            prettyReport.get(data[1]).add(data[0]);
        }

        for(int i=0;i<id_list.length;i++) {
            HashSet<String> set = prettyReport.get(id_list[i]);

            if(set.size() >= k) {
                for(String s : set) {
                    repCnt.put(s, repCnt.get(s)+1);
                }
            }
        }

        for(int i=0;i<id_list.length;i++)
            answer[i] = repCnt.get(id_list[i]);

        return answer;
    }
}
