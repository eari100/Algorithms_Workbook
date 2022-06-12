package Baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2230
 * @classfication: two pointer, sliding window
 * @reference: https://www.acmicpc.net/problem/2230
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.12 (O)
 **/
public class Q2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int maxMin = 2000000000;
        int min = 0;

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int str=0,end=1;str<arr.length && end<arr.length;) {
            min = arr[end] - arr[str];
            if(min == M) {
                maxMin = min;
                break;
            } else if(min > M) {
                maxMin = Math.min(maxMin, min);
                ++str;
            } else if(min < M) {
                ++end;
            }
        }

        System.out.print(maxMin);
    }
}
