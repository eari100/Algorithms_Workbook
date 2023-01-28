package Baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/5618 (공약수)
 *@classfication: math
 * @문제 푼 날짜 (자력으로 풂?): 23.01.26 (O, 업솔빙 시 유클리드 호제법으로 풀어 볼 것)
 **/
public class Q5618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int smallestNum = 100_000_000;
        StringBuilder measures = new StringBuilder();
        measures.append(1).append('\n');

        for(int i=0;i<nums.length;i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;

            smallestNum = Math.min(smallestNum, num);
        }

        br.close();

        for(int measure=2;measure<smallestNum+1;measure++) {
            for(int i=0;i<nums.length;i++) {
                if( !checkMeasure(nums[i], measure) ) break;

                if(i==nums.length-1) measures.append(measure).append('\n');
            }
        }

        System.out.print(measures);
    }

    private static boolean checkMeasure(int num, int measure) {
        return num % measure == 0;
    }
}
