package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/6603 (로또)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.07.23 (O)
 **/
public class Q6603 {
    static int[] nums;
    static int[] tempNums;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            int numCnt = Integer.parseInt(st.nextToken());

            if(numCnt == 0) break;

             nums = new int[numCnt];
            tempNums = new int[6];

            for(int i=0;i<numCnt;i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);

            result.append('\n');
        }

        System.out.print(result);
    }

    private static void dfs(int str, int depth) {
        if(depth == 6) {
            for(int num : tempNums) {
                result.append(num).append(' ');
            }

            result.append('\n');

            return;
        }

        for(int i=str;i<nums.length;i++) {
            tempNums[depth] = nums[i];
            dfs(i+1, depth+1);
        }
    }
}
