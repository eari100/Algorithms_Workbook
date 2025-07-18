package Programmers.implementation;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/161990 (바탕화면 정리)
 * @classification: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 25.07.18 (O)
 **/
public class Q161990 {
    public int[] solution(String[] wallpaper) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0};

        for(int i=0;i<wallpaper.length;i++) {
            for(int j=0;j<wallpaper[0].length();j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    answer[0] = Math.min(answer[0], i);
                    answer[1] = Math.min(answer[1], j);
                    answer[2] = Math.max(answer[2], i+1);
                    answer[3] = Math.max(answer[3], j+1);
                }
            }
        }

        return answer;
    }
}
