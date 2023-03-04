package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/12018 (Yonsei TOTO)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.03.04 (O)
 **/
public class Q12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] mileages = new int[n];
        int 수강_가능한_강의_수 = 0;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[] 수강신청자들 = new int[P];
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<수강신청자들.length;j++)
                수강신청자들[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(수강신청자들);

            if(수강신청자들.length < L)
                mileages[i] = 1;
            else
                mileages[i] = 수강신청자들[수강신청자들.length - L];
        }

        br.close();

        Arrays.sort(mileages);

        for(int i=0;i<mileages.length;i++) {
            m -= mileages[i];

            if(m < 0) break;

            ++수강_가능한_강의_수;
        }

        System.out.print(수강_가능한_강의_수);
    }
}
