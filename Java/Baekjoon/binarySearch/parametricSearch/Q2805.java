package Baekjoon.binarySearch.parametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2805 (나무 자르기)
 * @classification: parametric search
 * @문제 푼 날짜 (자력으로 풂?): 23.11.28 (O)
 **/
public class Q2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        br.close();

        int str = 1;
        int end = trees[trees.length - 1] - 1;
        int bestMid = 0;

        while(str <= end) {
            int mid = ( str + end ) / 2;
            long cut = 0;

            for(int i=trees.length-1;i>=0;i--) {
                int height = trees[i];

                if(mid >= height) break;

                cut += height - mid;
            }

            if(cut == M) {
                bestMid = mid;
                break;
            } else if(cut < M) {
                end = mid - 1;
            } else if(cut > M) {
                bestMid = mid;
                str = mid + 1;
            }
        }

        System.out.print(bestMid);
    }
}
