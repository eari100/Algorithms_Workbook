package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/15486 (퇴사 2)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?): 23.08.26 (O, 2시간 이상 걸린 듯)
 **/
// advice: 여러 문제를 한번에 푸는 것이 아니라 분할해서 풀 것
public class Q15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] days = new int[N+1][2];

        days[0] = new int[]{0, 0};

        for(int i=1;i<=N;i++) {
            days[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        br.close();

        int[] memo = new int[N+1];

        for(int i=1;i<=N;i++) {
            memo[i] = Math.max(memo[i], memo[i-1]);

            int[] day = days[i];
            int next = i + day[0] - 1;

            if(next <= N)
                memo[next] = Math.max(memo[next], memo[i-1] + day[1]);
        }

        System.out.print(memo[N]);
    }
}
