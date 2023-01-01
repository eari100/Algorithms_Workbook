package Baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1166 (선물)
 * @classfication: binary search
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 23.01.01 (X)
 **/
public class Q1166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long N = Long.parseLong(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());
        double start = 0;
        double end = Math.min(Math.min(L, W), H);

        while(true) {
            double mid = (end + start) / 2;

            if((long)(L / mid) * (long)(W / mid) * (long)(H / mid) >= N) {
                if(start == mid) break;

                start = mid;
            } else {
                if(end == mid) break;

                end = mid;
            }
        }

        System.out.print(start);
    }
}
