package Baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/18110 (solved.ac)
 * @classfication: math
 * @문제 푼 날짜 (자력으로 풂?): 23.08.24 (O)
 **/
public class Q18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        Arrays.sort(nums);
        int removeCnt = (int) Math.round(n * 0.15);
        double sum = 0;

        for(int i=removeCnt;i<n-removeCnt;i++) {
            sum += nums[i];
        }

        System.out.println(Math.round(sum / (n - (2 * removeCnt))));
    }
}
