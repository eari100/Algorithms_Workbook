package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/4796 (캠핑)
 * @classfication: greedy
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.08.05 (O)
 **/
public class Q4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int caseX = 0;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if(L == 0 && P == 0 && V == 0) break;

            int div = V / P;
            int mod = V % P;
            int result = (div * L) + Math.min(L, mod);
            sb.append("Case ").append(++caseX).append(": ").append(result).append('\n');
        }
        br.close();

        System.out.print(sb);
    }
}
