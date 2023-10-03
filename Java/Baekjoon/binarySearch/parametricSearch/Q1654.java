package Baekjoon.binarySearch.parametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1654 (랜선 자르기)
 * @classfication: binary search
 * @문제 푼 날짜 (자력으로 풂?): 23.10.03 (X, 이분탐색 발상은 떠올렸으나 최대 크기로 랜선으로 탐색해야 된다는 논리를 맞추지 못함)
 **/
public class Q1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int maxLAN = 0;
        int[] LANs = new int[K];

        for(int i=0;i<K;i++) {
            int LAN = Integer.parseInt(br.readLine());
            LANs[i] = LAN;

            maxLAN = Math.max(maxLAN, LAN);
        }

        br.close();

        long result = 0;
        long str = 1;
        long end = maxLAN;

        while (str <= end) {
            // overflow
            long mid = (str + end) / 2;
            int div = 0;

            for(int LAN: LANs)
                div += LAN / mid;

            if(div < N) {
                end = mid-1;
            } else {
                str = mid+1;
                result = Math.max(result, mid);
            }
        }

        System.out.print(result);
    }
}
