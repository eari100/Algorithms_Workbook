package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/2529 (부등호)
 * @classfication: backtracking
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.04.01 (O, 자료형 overflow 와 Array 깊은 복사 주의)
 **/
public class Q2529 {
    static boolean[] visited = new boolean[10];
    static long max = 0;
    static long min = Long.MAX_VALUE;
    static int[] minNums;
    static int[] maxNums;

    static int k;
    static String[] 부등호_모음;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        minNums = new int[k+1];
        maxNums = new int[k+1];
        부등호_모음 = br.readLine().split(" ");
        br.close();

        backtracking(0, new int[k+1]);

        StringBuilder result = new StringBuilder();

        Arrays.stream(maxNums).forEach(result::append);
        result.append('\n');
        Arrays.stream(minNums).forEach(result::append);
        System.out.print(result);
    }

    private static void backtracking(int depth, int[] nums) {
        if(depth > k) {
            long result = 0;
            for(int i=0;i<nums.length;i++) {
                result += Math.pow(10, k-i) * nums[i];
            }

            if(min > result) {
                min = result;
                minNums = Arrays.copyOf(nums, nums.length);
            }

            if(max < result) {
                max = result;
                maxNums = Arrays.copyOf(nums, nums.length);
            }

            return;
        }

        for(int num=0;num<10;num++) {
            if(visited[num]) continue;

            if(depth > 0) {
                String 부등호 = 부등호_모음[depth-1];

                if(부등호.equals("<")) {
                    if(nums[depth-1] > num) continue;
                } else if(부등호.equals(">")) {
                    if(nums[depth-1] < num) continue;
                }
            }

            visited[num] = true;
            nums[depth] = num;
            backtracking(depth+1, nums);
            visited[num] = false;
        }
    }
}
