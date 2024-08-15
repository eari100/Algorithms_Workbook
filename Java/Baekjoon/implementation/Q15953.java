package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/15953 (상금 헌터)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.08.15 (O)
 **/
public class Q15953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rank1 = Integer.parseInt(st.nextToken());
            int rank2 = Integer.parseInt(st.nextToken());

            result.append(prizeMoney1(rank1) + prizeMoney2(rank2)).append('\n');
        }

        br.close();

        System.out.print(result);
    }

    private static int prizeMoney1(int rank) {
        if(rank == 0) {
            return 0;
        } else if(rank == 1) {
            return 5_000_000;
        } else if(rank <= 3) {
            return 3_000_000;
        } else if(rank <= 6) {
            return 2_000_000;
        } else if(rank <= 10) {
            return 500_000;
        } else if(rank <= 15) {
            return 300_000;
        } else if(rank <= 21) {
            return 100_000;
        } else {
            return 0;
        }
    }

    private static int prizeMoney2(int rank) {
        if(rank == 0) {
            return 0;
        } else if(rank == 1) {
            return 5_120_000;
        } else if(rank <= 3) {
            return 2_560_000;
        } else if(rank <= 7) {
            return 1_280_000;
        } else if(rank <= 15) {
            return 640_000;
        } else if(rank <= 31) {
            return 320_000;
        } else {
            return 0;
        }
    }
}
