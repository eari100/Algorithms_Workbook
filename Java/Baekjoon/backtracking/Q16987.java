package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/16987 (계란으로 계란치기)
 * @classification: backtracking
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.10.11 (O)
 **/
public class Q16987 {
    static int maxBrokenEggs = 0;
    static int[][] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];

        for(int i=0;i<N;i++) {
            eggs[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        bt(0, 0);
        System.out.print(maxBrokenEggs);
        br.close();
    }

    private static void bt(int eggIndex, int brokenEggs) {
        if(eggIndex == eggs.length) {
            maxBrokenEggs = Math.max(maxBrokenEggs, brokenEggs);
            return;
        }

        int[] egg1 = eggs[eggIndex];
        int durability1 = egg1[0];
        int weight1 = egg1[1];

        if(durability1 <= 0) {
            bt(eggIndex+1, brokenEggs);
            return;
        }

        boolean isNext = false;

        for(int i=0;i<eggs.length;i++) {
            if(i == eggIndex) continue;

            int[] egg2 = eggs[i];
            int durability2 = egg2[0];
            int weight2 = egg2[1];

            if(durability2 <= 0) continue;

            isNext = true;
            eggs[eggIndex][0] -= weight2;
            eggs[i][0] -= weight1;

            int brokenEggs2 = 0;

            if(eggs[eggIndex][0] <= 0)
                ++brokenEggs2;
            if(eggs[i][0] <= 0)
                ++brokenEggs2;

            bt(eggIndex+1, brokenEggs + brokenEggs2);

            eggs[eggIndex][0] += weight2;
            eggs[i][0] += weight1;
        }

        if( !isNext ) {
            bt(eggIndex+1, brokenEggs);
        }
    }
}
