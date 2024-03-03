package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @source: https://www.acmicpc.net/problem/1941 (소문난 칠공주)
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 24.03.03 (X, 조합 공식 몰라서 시간복잡도 계산 잘못함)
 **/
public class Q1941 {
    static int answer = 0;
    static char[][] classRoom = new char[5][5];
    final static int[] nX = {-1, 1, 0, 0};
    final static int[] nY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<5;i++) {
            String row = br.readLine();
            for(int j=0;j<5;j++) {
                classRoom[i][j] = row.charAt(j);
            }
        }

        br.close();

        combination(0, 0, new int[7], 0);

        System.out.print(answer);
    }

    private static void combination(int start, int depth, int[] comb, int sCnt) {
        if(depth == 7) {
            if(sCnt >= 4)
                checkAnswer(comb);

            return;
        }

        for(int i=start;i<25;i++) {
            comb[depth] = i;

            combination(i+1, depth+1, comb, classRoom[i/5][i%5] == 'S' ? sCnt+1 : sCnt);
        }
    }

    private static void checkAnswer(int[] nums) {
        int connect = 0;
        boolean[][] visited = new boolean[5][5];
        int x = nums[0] / 5, y = nums[0] % 5;
        visited[x][y] = true;
        ++connect;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0], y1 = poll[1];

            for(int i=0;i<4;i++) {
                int x2 = x1 + nX[i], y2 = y1 + nY[i];

                if(x2 < 0 || x2 >= 5 || y2 < 0 || y2 >= 5) continue;
                if(visited[x2][y2]) continue;

                visited[x2][y2] = true;

                for(int num : nums) {
                    int nextX = num / 5, nextY = num % 5;

                    if(nextX == x2 && nextY == y2) {
                        queue.offer(new int[]{x2, y2});
                        ++connect;
                    }
                }
            }
        }

        if(connect == 7) {
            ++answer;
        }
    }
}
