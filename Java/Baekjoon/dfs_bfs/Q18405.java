package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/18405 (경쟁적 전염)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 24.08.25 (O)
 * @reference: https://www.acmicpc.net/source/76582538 (다른 풀이)
 **/
public class Q18405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> {
            if(p1[1] == p2[1]) {
                return p1[0] - p2[0];
            } else {
                return p1[1] - p2[1];
            }
        });

        int n = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];

        final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<n;j++) {
                int obj = Integer.parseInt(st.nextToken());

                if(obj > 0)
                    queue.offer(new int[]{obj, 0, i, j});

                map[i][j] = obj;
            }
        }

        st = new StringTokenizer(br.readLine());

        int time = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        br.close();

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int virus = poll[0], t = poll[1], x1 = poll[2], y1 = poll[3];

            if(t == time) break;

            for(int[] d : dir) {
                int x2 = x1 + d[0], y2 = y1 + d[1];

                if(x2 < 0 || x2 >= n || y2 < 0 || y2 >= n || map[x2][y2] > 0)
                    continue;

                map[x2][y2] = virus;
                queue.offer(new int[]{virus, t+1, x2, y2});
            }
        }

        System.out.print(map[x-1][y-1]);
    }
}
