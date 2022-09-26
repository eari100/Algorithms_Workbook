package Baekjoon.greedy.Q1449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1449 (수리공 항승)
 * @classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?): 22.09.26 (O)
 **/
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] holes = new int[N];
        int result = 1;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            holes[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(holes);

        double last = holes[0] - 0.5 + L;

        for(int i=1;i<N;i++) {
            double x = holes[i] - 0.5;
            if(x > last) {
                last = holes[i] - 0.5 + L;
                ++result;
            } else if(x == last) {
                last += L;
                ++result;
            }
        }

        br.close();

        System.out.print(result);
    }
}
