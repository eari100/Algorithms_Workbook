package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/7562 (나이트의 이동)
 * @classfication: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.03.11 (O)
 **/
public class Q7562 {
    static final int[] nX = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] nY = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] 체스판;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCaseCnt = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCaseCnt; i++) {
            int row = Integer.parseInt(br.readLine());
            체스판 = new int[row][row];

            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            체스판[startY][startX] = 1;

            st = new StringTokenizer(br.readLine());

            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            bfs(startX, startY);
            result.append(체스판[endY][endX] - 1).append('\n');
        }

        br.close();

        System.out.print(result);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int pX = poll[0];
            int pY = poll[1];

            for(int i=0;i<nX.length;i++) {
                int qX = pX + nX[i];
                int qY = pY + nY[i];

                if(qX < 0 || qX > 체스판.length - 1 || qY < 0 || qY > 체스판[0].length - 1 ) continue;
                if(체스판[qY][qX] != 0) continue;

                체스판[qY][qX] = 체스판[pY][pX] + 1;

                queue.offer(new int[]{qX, qY});
            }
        }
    }
}
