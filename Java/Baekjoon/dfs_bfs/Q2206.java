package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2206 (벽 부수고 이동하기)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.12.15 (X)
 **/
public class Q2206 {
    static int[][] map;
    static boolean[][][] visited;
    static final int[] nX = {-1, 1, 0, 0};
    static final int[] nY = {0, 0, -1, 1};
    static int dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w][2];

        for(int i=0;i<h;i++) {
            String row = br.readLine();
            for(int j=0;j<w;j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        br.close();

        bfs(0, 0);

        System.out.print(dist == 0 ? -1 : dist);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 1, 1});
        visited[x][y][0] = true;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            int skillCnt = poll[2];
            int d1 = poll[3];

            if(x1 == map.length-1 && y1 == map[0].length-1){
                dist = d1;
                return;
            }

            for(int i=0;i<nX.length;i++) {
                int x2 = x1 + nX[i];
                int y2 = y1 + nY[i];
                int d2 = d1 + 1;

                if(x2 < 0 || x2 >= map.length || y2 < 0 || y2 >= map[0].length) continue;

                if(map[x2][y2] == 1) {
                    if(skillCnt == 1 && !visited[x2][y2][1]) {
                        queue.offer(new int[]{x2, y2, skillCnt-1, d2});
                        visited[x2][y2][1] = true;
                    }
                } else if(map[x2][y2] == 0) {
                    if( skillCnt == 1 && !visited[x2][y2][0] ) {
                        queue.offer(new int[]{x2, y2, skillCnt, d2});
                        visited[x2][y2][0] = true;
                    } else if(skillCnt == 0 && !visited[x2][y2][1] ) {
                        queue.offer(new int[]{x2, y2, skillCnt, d2});
                        visited[x2][y2][1] = true;
                    }
                }
            }
        }
    }
}
