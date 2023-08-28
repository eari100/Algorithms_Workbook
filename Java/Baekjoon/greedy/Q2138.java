package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/2138 (전구와 스위치)
 * @classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?): 23.08.28 (X, 그리디적인 해결 방법을 생각조차 못함)
 **/
public class Q2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] case1 = toArray(br.readLine());
        int[] case2 = Arrays.copyOf(case1, case1.length);

        flip(case2, 0);

        int[] target = toArray(br.readLine());

        br.close();

        int case1FlipCnt = 0, case2FlipCnt = 1;

        for(int i=1;i<N;i++) {
            if(checkPrevData(case1, target, i))
                ++case1FlipCnt;

            if(checkPrevData(case2, target, i))
                ++case2FlipCnt;
        }

        int result = 0;

        boolean case1Result = isMatch(case1, target);
        boolean case2Result = isMatch(case2, target);

        if( !case1Result && !case2Result) {
            result = -1;
        } else if(case1Result) {
            result = case1FlipCnt;
        } else if(case2Result) {
            result = case2FlipCnt;
        } else {
            result = Math.min(case1FlipCnt, case2FlipCnt);
        }

        System.out.print(result);
    }

    private static boolean checkPrevData(int[] bulbs, int[] target, int index) {
        if(bulbs[index - 1] != target[index - 1]) {
            flip(bulbs, index);
            return true;
        }

        return false;
    }

    private static int solve(int[] bulbs, int[] target, int flipCnt) {
        for(int i=1;i<bulbs.length;i++) {
            if(bulbs[i - 1] != target[i - 1]) {
                flip(bulbs, i);
                ++flipCnt;
            }
        }

        return isMatch(bulbs, target) ? flipCnt : Integer.MAX_VALUE;
    }

    private static boolean isMatch(int[] bulbs, int[] target) {
        for(int i=0;i<bulbs.length;i++) {
            if(bulbs[i] != target[i]) {
                return false;
            }
        }

        return true;
    }

    private static void flip(int[] bulbs, int s) {
        if(s == 0) {
            bulbs[0] = bulbs[0]^1;
            bulbs[1] = bulbs[1]^1;
        } else if(s == bulbs.length - 1) {
            bulbs[s - 1] = bulbs[s - 1]^1;
            bulbs[s] = bulbs[s]^1;
        } else {
            bulbs[s - 1] = bulbs[s - 1]^1;
            bulbs[s] = bulbs[s]^1;
            bulbs[s + 1] = bulbs[s + 1]^1;
        }
    }

    private static int[] toArray(String str) {
        return Arrays.stream(str.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
