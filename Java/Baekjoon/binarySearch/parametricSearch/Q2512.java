package Baekjoon.binarySearch.parametricSearch;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2512 (예산)
 * @classfication: parametric search
 * @문제 푼 날짜 (자력으로 풂?): 23.12.08 (O)
 **/
public class Q2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int[] moneys = new int[N];
        for(int i=0;i<N;i++) {
            int money = Integer.parseInt(st.nextToken());
            max = Math.max(max, money);
            moneys[i] = money;
        }

        int sum = Integer.parseInt(br.readLine());
        int min = 1;
        int answer = 0;

        while(min <= max) {
            int mid = (min + max) / 2;

            int sum2 = 0;

            for(int money : moneys) {
                if(mid >= money) {
                    sum2 += money;
                } else {
                    sum2 += mid;
                }
            }

            if(sum2 > sum) {
                max = mid - 1;
            } else if(sum2 <= sum) {
                answer = mid;
                min = mid + 1;
            }
        }

        br.close();
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
