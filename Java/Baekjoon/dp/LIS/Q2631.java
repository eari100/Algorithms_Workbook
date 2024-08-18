package Baekjoon.dp.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2631 (줄세우기)
 * @classification: LIS
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.18 (O)
 **/
public class Q2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] LIS = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        for(int i=0;i<n;i++) {
            int curr = nums[i];

            for(int j=i+1;j<n;j++) {
                int next = nums[j];

                if(curr < next) {
                    LIS[j] = Math.max(LIS[j], LIS[i] + 1);
                    max = Math.max(max, LIS[j]);
                }
            }
        }

        System.out.print(n - (max + 1));
    }
}
