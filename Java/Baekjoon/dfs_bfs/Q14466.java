package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14466 (소가 길을 건너간 이유 6)
 * @classfication: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.07.29 (X, 인접행렬 만드는 법, 실행 속도)
 **/
public class Q14466 {
    final static int[] nX = {-1, 1, 0, 0};
    final static int[] nY = {0, 0, -1, 1};

    static HashSet<int[]>[][] loads;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        loads = new HashSet[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                loads[i][j] = new HashSet<>();
            }
        }

        int[][] cows = new int[K][2];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            loads[x1][y1].add(new int[]{x2, y2});
            loads[x2][y2].add(new int[]{x1, y1});
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            cows[i] = new int[]{x, y};
        }

        br.close();

        for (int i = 0; i < cows.length - 1; i++) {
            boolean[][] visited = new boolean[N][N];
            doesTheCowCrossTheRoad(cows[i][0], cows[i][1], visited);

            for (int j = i + 1; j < cows.length; j++) {
                int[] cow = cows[j];

                if( !visited[cow[0]][cow[1]] ) ++result;
            }
        }

        System.out.print(result);
    }

    private static void doesTheCowCrossTheRoad(int x1, int y1, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x1, y1});
        visited[x1][y1] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            HashSet<int[]> directions = loads[poll[0]][poll[1]];

            L1:
            for (int i = 0; i < nX.length; i++) {
                int x2 = poll[0] + nX[i];
                int y2 = poll[1] + nY[i];

                if (x2 < 0 || x2 >= visited.length || y2 < 0 || y2 >= visited.length)
                    continue;

                if (visited[x2][y2])
                    continue;

                for (int[] direction : directions) {
                    if (direction[0] == x2 && direction[1] == y2)
                        continue L1;
                }

                queue.offer(new int[]{x2, y2});
                visited[x2][y2] = true;
            }
        }
    }
}

