package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/4159 (알래스카)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.12.31 (O)
 **/
public class Q4159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        final int goal = 1422;

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) break;

            int[] gasStations = new int[n];

            for(int i = 0; i < n; i++) {
                gasStations[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(gasStations);

            boolean isPossible = true;

            for(int i = 1; i < n; i++) {
                int prev = gasStations[i-1];
                int curr = gasStations[i];

                if(prev + 200 < curr) {
                    isPossible = false;
                    break;
                }
            }

            if(goal - gasStations[n-1] > 100) {
                isPossible = false;
            }

            result.append(isPossible ? "POSSIBLE" : "IMPOSSIBLE").append('\n');
        }

        br.close();

        System.out.print(result);
    }
}
