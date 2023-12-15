package Baekjoon.slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/21921 (블로그)
 * @classification: 슬라이딩 윈도우, 누적합
 * @문제 푼 날짜 (자력으로 풂?): 23.12.15 (O)
 **/
public class Q21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final String SAD = "SAD";
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] visits = new int[n+1];
        long[] memo = new long[n+1];
        st = new StringTokenizer(br.readLine());

        long mostVisit = 0;
        int mostVisitCnt = 0;

        for(int i=1;i<=n;i++) {
            int visit = Integer.parseInt(st.nextToken());
            visits[i] = visit;

            if(i<=x) {
                memo[x] += visit;
            } else {
                memo[i] = memo[i-1] - visits[i-x] + visit;
            }

            if(mostVisit < memo[i]) {
                mostVisit = memo[i];
                mostVisitCnt = 1;
            } else if(mostVisit == memo[i]) {
                ++mostVisitCnt;
            }
        }

        br.close();

        StringBuilder result = new StringBuilder();
        if(mostVisit == 0) {
            result.append(SAD);
        } else {
            result.append(mostVisit).append('\n').append(mostVisitCnt);
        }
        System.out.print(result);
    }
}
