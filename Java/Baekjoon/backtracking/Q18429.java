package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/18429 (근손실)
 *@classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.01.23 (O)
 **/
public class Q18429 {
    static boolean[] visited;
    static int answer;
    static int lossWeight;
    static final int minWeight = 500;
    static int currentWeight = minWeight;
    static int[] weights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        lossWeight = Integer.parseInt(st.nextToken());
        weights = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        br.close();

        for(int i=0;i<N;i++)
            weights[i] = Integer.parseInt(st.nextToken());

        dfs(0);

        System.out.print(answer);
    }

    private static void dfs(int depth) {
        if(depth == weights.length) {
            ++answer;
            return;
        }

        for(int i=0;i<weights.length;i++) {
            if(!visited[i] && currentWeight - lossWeight + weights[i] >= minWeight) {
                visited[i] = true;
                currentWeight = currentWeight - lossWeight + weights[i];
                dfs(depth+1);
                visited[i] = false;
                currentWeight = currentWeight + lossWeight - weights[i];
            }
        }
    }
}
