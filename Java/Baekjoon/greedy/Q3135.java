package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/3135 (라디오)
 * @classfication: greedy
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.08.03 (O)
 **/
public class Q3135 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gap = Math.abs(B-A);

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {
            int go = Integer.parseInt(br.readLine());
            gap = Math.min(gap, Math.abs(B-go));
        }

        br.close();

        if(A==B) System.out.print(0);
        else if(gap==Math.abs(B-A)) System.out.println(gap);
        else System.out.println(gap+1);
    }
}
