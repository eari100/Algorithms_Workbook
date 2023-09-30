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
public class Q30242 {
    static int[] queens;
    static boolean[] down;
    static boolean[] diagonalRL;
    static boolean[] diagonalLR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        queens = new int[N];
        down = new boolean[N];
        diagonalRL = new boolean[2*N-1];
        diagonalLR = new boolean[2*N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int x=0;x<N;x++) {
            int y = Integer.parseInt(st.nextToken());
            int comY = y-1;

            if(y != 0) {
                if(down[comY] || diagonalRL[x+comY] || diagonalLR[x-comY+(N-1)]) {
                    System.out.print(-1);
                    System.exit(0);
                }

                down[comY] = true;
                diagonalRL[x+comY] = true;
                diagonalLR[x-comY+(N-1)] = true;
            }

            queens[x] = y;
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
                if(down[i]) continue;
                if(diagonalRL[depth+i]) continue;
                if(diagonalLR[depth-i+(queens.length-1)]) continue;

                nQueens[depth] = i;

                down[i] = true;
                diagonalRL[depth+i] = true;
                diagonalLR[depth-i+(queens.length-1)] = true;
                dfs(nQueens, depth+1);
                down[i] = false;
                diagonalRL[depth+i] = false;
                diagonalLR[depth-i+(queens.length-1)] = false;
            }
        } else {
            int currY = fixY - 1;

            nQueens[depth] = currY;
            dfs(nQueens, depth+1);
        }
    }
}
