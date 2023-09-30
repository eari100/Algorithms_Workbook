package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/7569 (7569)
 * @classfication: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.09.30 (O, bfs에 날짜 요소를 곁들인 유형)
 **/
public class Q7569 {
    static final int[][] directions = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0},  {0, 1, 0}, {0, 0, -1},  {0, 0, 1}};
    static int[][][] box;
    static int redCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        int totalTotalCnt = M * N * H;

        box = new int[H][N][M];

        for(int i=0;i<H;i++) {
            for(int j=0;j<N;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++) {
                    int status = Integer.parseInt(st.nextToken());
                    box[i][j][k] = status;

                    if(status == 1) {
                        ++redCnt;
                        queue.offer(new int[]{i,j,k});
                    } else if(status == -1) {
                        --totalTotalCnt;
                    }
                }
            }
        }

        br.close();

        int days = bfs(0, queue);

        System.out.print(redCnt == totalTotalCnt ? days : -1);
    }

    private static int bfs(int day, Queue<int[]> queue) {
        Queue<int[]> nextQueue = new LinkedList<>();

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            int z1 = poll[2];

            for(int i=0;i<directions.length;i++) {
                int x2 = x1 + directions[i][0];
                int y2 = y1 + directions[i][1];
                int z2 = z1 + directions[i][2];

                if(x2 < 0 || x2 >= box.length || y2 < 0 || y2 >= box[0].length || z2 < 0 || z2 >= box[0][0].length)
                    continue;

                if(box[x2][y2][z2] == -1 || box[x2][y2][z2] == 1)
                    continue;

                ++redCnt;
                box[x2][y2][z2] = 1;
                nextQueue.offer(new int[]{x2, y2, z2});
            }
        }

        return nextQueue.isEmpty() ? day : bfs(day+1, nextQueue);
    }
}
