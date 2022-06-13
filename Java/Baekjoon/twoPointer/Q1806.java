package Baekjoon.twoPointer;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1806
 * @classfication: two pointer, sliding window
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.13 (O)
 **/
public class Q1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        br.close();

        int str = -1;
        int end = -1;
        int minSize = 100000;
        int nSize = 0;
        int sum = 0;

        while(str < N && end < N) {
            if(sum >= S) {
                minSize = Math.min(minSize, nSize);
                if(minSize == 1) break;
            }

            if(sum < S/* || str == end*/) {
                if(end == N-1) break;

                sum += arr[++end];
                ++nSize;
                continue;
            }

            sum -= arr[++str];
            --nSize;
        }

        System.out.print(minSize == 100000 ? 0 : minSize);
    }
}
