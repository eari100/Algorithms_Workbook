package Baekjoon.dfs_bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/4963 (섬의 개수)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.12.08 (O)
 **/
public class Q4963 {
    final static int LAND = 1;
    final static int SEA = 0;
    final static int[] nX = {-1, -1, 0, 1, 1, 1, 0, -1};
    final static int[] nY = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            for(int i=0;i<h;i++) {
                StringTokenizer row = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++) {
                    int obj = Integer.parseInt(row.nextToken());
                    map[i][j] = obj;
                }
            }

            int landCnt = 0;

            for(int i=0;i<h;i++) {
                for(int j=0;j<w;j++) {
                    if(!visited[i][j] && map[i][j] == LAND) {
                        ++landCnt;
                        bfs(map, visited, i, j);
                    }
                }
            }

            result.append(landCnt).append('\n');
        }

        br.close();

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int[][] map, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];

            for(int i=0;i<nX.length;i++) {
                int x2 = x1 + nX[i];
                int y2 = y1 + nY[i];

                if(x2 < 0 || x2 >= map.length || y2 < 0 || y2 >= map[0].length)
                    continue;

                if(map[x2][y2] == SEA)
                    continue;

                if(visited[x2][y2])
                    continue;

                queue.offer(new int[]{x2, y2});
                visited[x2][y2] = true;
            }
        }
    }
}
