package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2885 (초콜릿 식사)
 * @classfication: greedy
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.04.17 (X)
 **/
public class Q2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sanggeunChoco = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder result = new StringBuilder();
        int chocoSize = getChocoSize(sanggeunChoco);
        int breakCnt = getBreakCnt(chocoSize, sanggeunChoco);

        result.append(chocoSize).append(' ').append(breakCnt);
        System.out.print(result);
    }

    private static int getChocoSize(int sanggeunChoco) {
        int chocoSize = 0, line = 0;
        while((chocoSize = (int)Math.pow(2, line)) < sanggeunChoco) {
            ++line;
        }

        return chocoSize;
    }

    private static int getBreakCnt(int chocoSize, int sanggeunChoco) {
        int breakCnt = 0;

        while(sanggeunChoco > 0) {
            if(sanggeunChoco < chocoSize) {
                chocoSize /= 2;
                ++breakCnt;
            } else {
                sanggeunChoco -= chocoSize;
            }
        }

        return breakCnt;
    }
}
