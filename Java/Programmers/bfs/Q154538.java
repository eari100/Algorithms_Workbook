package Programmers.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/154538 (숫자 변환하기)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 24.09.04 (X)
 **/
public class Q154538 {
    public int solution(int x, int y, int n) {
        final int INF = 1_000_000 + 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(y);

        int[] dp = new int[y + 1];

        for(int i=x;i<y;i++) {
            dp[i] = INF;
        }

        while( !queue.isEmpty() ) {
            int prev = queue.poll();

            int next1 = prev - n;
            if(x <= next1 && dp[next1] == INF) {
                dp[next1] = dp[prev] + 1;

                if(x < next1)
                    queue.offer(next1);
            }

            int next2 = prev / 2;
            int mod2 = prev % 2;
            if(mod2 == 0 && dp[next2] == INF) {
                dp[next2] = dp[prev] + 1;

                if(x < next2)
                    queue.offer(next2);
            }

            int next3 = prev / 3;
            int mod3 = prev % 3;
            if(mod3 == 0 && dp[next3] == INF) {
                dp[next3] = dp[prev] + 1;

                if(x < next3)
                    queue.offer(next3);
            }
        }

        return dp[x] == INF ? -1 : dp[x];
    }
}
