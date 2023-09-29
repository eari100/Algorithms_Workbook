package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/30242 (🧩 N-Queen (Easy))
 * @classfication: backtracking
 * @reference: https://www.acmicpc.net/source/67327590 (대각선 메모이제이션)
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.09.30 (O, 대각선 메모이제이션 않았음)
 **/
// todo: 대각선 메모이제이션하는 방법으로 변경할 것!
public class Q30242 {
    static int[] queens;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        queens = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int y = Integer.parseInt(st.nextToken());
            if(y != 0 && visited[y-1]) {
                System.out.print(-1);
                System.exit(0);
            }

            queens[i] = y;
            if(y != 0)
                visited[y-1] = true;
        }

        br.close();
        dfs(new int[N], 0);

        System.out.print(-1);
    }

    private static void dfs(int[] nQueens, int depth) {
        if(depth == queens.length) {
            StringBuilder answer = new StringBuilder();
            Arrays.stream(nQueens)
                    .forEach(q -> answer.append(q+1).append(' '));

            System.out.print(answer);
            System.exit(0);
        }

        int fixY = queens[depth];

        if(fixY == 0) {
            for(int i=0;i<queens.length;i++) {
                boolean flag = depth == 0;

                if(visited[i]) continue;

                for(int j=0;j<depth;j++) {
                    int prevY = nQueens[j];

                    if(j - depth == -(prevY - i)) break;
                    if(j - depth == prevY - i) break;

                    if(j == depth-1)
                        flag = true;
                }

                if(flag) {
                    nQueens[depth] = i;
                    visited[i] = true;
                    dfs(nQueens, depth+1);
                    visited[i] = false;
                }
            }
        } else {
            boolean flag = depth == 0;
            int currY = fixY - 1;

            for(int j=0;j<depth;j++) {
                int prevY = nQueens[j];

                if(j - depth == -(prevY - currY)) break;
                if(j - depth == prevY - currY) break;

                if(j == depth-1)
                    flag = true;
            }

            if(flag) {
                nQueens[depth] = currY;
                dfs(nQueens, depth+1);
            }
        }
    }
}
