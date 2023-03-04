package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/10819 (차이를 최대로)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.03.04 (X, 힌트 열람)
 **/
public class Q10819 {
    static boolean[] visited;
    static int[] nums;
    static int maxAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<nums.length;i++)
            nums[i] = Integer.parseInt(st.nextToken());

        br.close();

        for(int i=0;i<nums.length;i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            backtracking(1, nums[i], 0);
            visited[i] = false;
        }

        System.out.print(maxAnswer);
    }

    private static void backtracking(int depth, int prev, int answer) {
        if(depth == nums.length) {
            maxAnswer = Math.max(maxAnswer, answer);
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if( !visited[i] ) {
                visited[i] = true;
                backtracking(depth+1, nums[i], answer + Math.abs(prev - nums[i]));
                visited[i] = false;
            }
        }
    }
}
