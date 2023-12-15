package Baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1059 (좋은 구간)
 * @classification: math
 * @문제 푼 날짜 (자력으로 풂?): 23.12.16 (X, 엣지케이스 발견 x)
 **/
public class Q1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int[] S = new int[L+2];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=L;i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        S[0] = 0;
        S[L+1] = 1001;

        Arrays.sort(S);

        int n = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;

        for(int i=1;i<S.length;i++) {
            if(n < S[i]) {
                if(S[i-1] < n) {
                    result = ((n - (S[i-1]+1))+1) * (S[i]-n) - 1;
                }

                break;
            }
        }

        System.out.print(result);
    }
}
