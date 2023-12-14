package Baekjoon.dfs_bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/17836 (공주님을 구해라!)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.12.15 (O)
 **/
// todo: 정해는 그람을 얻은 뒤 공주까지 맨하튼 거리로 구하는 것
public class Q17836 {
    static int[][] map;
    static boolean[][][] visited;
    static final int[] nX = {-1, 1, 0, 0};
    static final int[] nY = {0, 0, -1, 1};
    static int timeLimit;
    static final int load = 0;
    static final int wall = 1;
    static final int gram = 2;
    static final String fail = "Fail";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        timeLimit = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        visited = new boolean[h][w][2];

        for(int i=0;i<h;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<w;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        int saveTime = bfs(0, 0);
        System.out.print(saveTime == -1 ? fail : saveTime);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0, 0});
        visited[x][y][load] = true;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            int t1 = poll[2];
            int g = poll[3];

            if(x1 == map.length -1 && y1 == map[0].length - 1) {
                return t1;
            }

            for(int i=0;i<nX.length;i++) {
                int x2 = x1 + nX[i];
                int y2 = y1 + nY[i];
                int t2 = t1 + 1;

                if(t2 > timeLimit) continue;
                if(x2 < 0 || x2 >= map.length || y2 < 0 || y2 >= map[0].length) continue;

                if(map[x2][y2] == load) {
                    if(g == 0) {
                        if(visited[x2][y2][load]) continue;

                        visited[x2][y2][load] = true;
                        queue.offer(new int[]{x2, y2, t2, g});
                    } else {
                        if(visited[x2][y2][wall]) continue;

                        visited[x2][y2][wall] = true;
                        queue.offer(new int[]{x2, y2, t2, g});
                    }
                } else if(map[x2][y2] == wall) {
                    if(g == 0) continue;
                    if(visited[x2][y2][wall]) continue;

                    visited[x2][y2][wall] = true;
                    queue.offer(new int[]{x2, y2, t2, g});
                } else if(map[x2][y2] == gram) {
                    queue.offer(new int[]{x2, y2, t2, 1});
                }
            }
        }

        return -1;
    }
}
