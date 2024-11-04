package Programmers.greedy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/118667 (2022 KAKAO TECH INTERNSHIP > 두 큐 합 같게 만들기)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 24.10.30 (O, 좋은 문제 업솔빙해보자. limit 지정하는데 사고를 오래함)
 **/
// todo: two pointer 로 가능
public class Q118667 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0, sum2 = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i : queue1) {
            q1.add(i);
            sum1 += i;
        }

        for(int i : queue2) {
            q2.add(i);
            sum2 += i;
        }

        if((sum1 + sum2) % 2 == 1) {
            return -1;
        }

        int size1 = q1.size(), size2 = q2.size();

        int limit = 0;

        if(size1 < size2) {
            limit = size1 * 2 + size2;
        } else {
            limit = size2 * 2 + size1;
        }

        while(sum1 != sum2) {
            if(limit < answer) return -1;

            if(sum1 < sum2) {
                int poll = q2.poll();
                q1.add(poll);
                sum2 -= poll;
                sum1 += poll;
                --size2;
                ++size1;
            } else {
                int poll = q1.poll();
                q2.add(poll);
                sum1 -= poll;
                sum2 += poll;
                --size1;
                ++size2;
            }

            ++answer;
        }

        return answer;
    }
}
