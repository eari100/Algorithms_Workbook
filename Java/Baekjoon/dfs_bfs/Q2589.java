package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/2589 (보물섬)
 * @classfication: bruteforce
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.03.22 (X, bruteforce 힌트 씀)
 **/
public class Q2589 {
    static char[][] map;
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        map = new char[height][width];
        boolean[][] visited;
        int maxDist = 0;

        for(int i=0;i<height;i++) {
            String row = br.readLine();

            for(int j=0;j<width;j++) {
                map[i][j] = row.charAt(j);
            }
        }

        br.close();

        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                if(map[i][j] == 'L') {
                    visited = new boolean[height][width];
                    maxDist = Math.max(maxDist, bfs(i, j, visited));
                }
            }
        }

        System.out.print(maxDist);
    }

    private static int bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y, 0});
        visited[x][y] = true;
        int dist = 0;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            dist = poll[2];

            for(int i=0;i< nx.length;i++) {
                int x2 = x1 + nx[i];
                int y2 = y1 + ny[i];

                if(x2 < 0 || x2 > map.length - 1 || y2 < 0 || y2 > map[0].length - 1) continue;
                if(map[x2][y2] == 'W' || visited[x2][y2]) continue;

                queue.offer(new int[]{x2, y2, dist + 1});
                visited[x2][y2] = true;
            }
        }

        return dist;
    }
}
