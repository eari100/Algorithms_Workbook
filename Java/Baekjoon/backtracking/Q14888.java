package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/14888 (연산자 끼워넣기)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.04.30 (X, maxValue 가 음수나올 경우를 생각하지 못함, 풀이식은 맞음, 백트래킹하는 부분에서 디버깅을 잘 못해서 오래 걸림)
 **/
public class Q14888 {
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;
    static int[] nums;
    static int[] 사칙연산;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        사칙연산 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        br.close();


        backtracking(1, nums[0]);

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    private static void backtracking(int depth, int value) {
        if(depth == nums.length) {
            maxValue = Math.max(maxValue, value);
            minValue = Math.min(minValue, value);

            return;
        }

        for(int i=0;i<사칙연산.length;i++) {
            if(사칙연산[i] != 0) {
                --사칙연산[i];

                if(i == 0) {
                    backtracking(depth+1, value + nums[depth]);
                } else if(i == 1) {
                    backtracking(depth+1, value - nums[depth]);
                } else if(i == 2) {
                    backtracking(depth+1, value * nums[depth]);
                } else if(i == 3) {
                    backtracking(depth+1, value / nums[depth]);
                }

                ++사칙연산[i];
            }
        }
    }
}
