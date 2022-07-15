package Programmers.greedy;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12979 (기지국 설치)
 * @classfication: greedy
 * @reference: https://small-stap.tistory.com/81
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.06 (X)
 * 2. 22.07.15 (X)
 **/
public class Q12979 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int str = 1;
        int radioRange = 2*w+1;

        for(int station : stations) {
            if(str < station-w) {
                int len = station-w-str;

                answer += len / radioRange;
                if(len % radioRange > 0) ++answer;
            }

            str = station+w+1;
        }

        if(stations[stations.length-1]+w < n) {
            int len = n+1-str;

            answer += len / radioRange;
            if(len % radioRange > 0) ++answer;
        }

        return answer;
    }
}
