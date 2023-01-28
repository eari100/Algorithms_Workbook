package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/15059 (Hard choice)
 *@classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.01.26 (O)
 **/
public class Q15059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] passenger = new int[3];

        int result = 0;

        for(int i=0;i<passenger.length;i++)
            passenger[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        br.close();

        for(int i=0;i<passenger.length;i++) {
            int foodCnt = Integer.parseInt(st.nextToken());
            int missing = foodCnt - passenger[i];

            if(missing > 0) result += missing;
        }

        System.out.print(result);
    }
}
