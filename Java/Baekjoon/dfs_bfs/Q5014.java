package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/5014 (스타트링크)
 * @classfication: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.10.04 (?, 힌트 보고 풂)
 **/
public class Q5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final String noWay = "use the stairs";

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[F+1];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{S, 0});
        int answer = -1;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x = poll[0];
            int cost = poll[1];

            if(x == G) {
                answer = cost;
                break;
            }

            if(!visited[x]) {
                int up = x+U;
                int down = x-D;

                if(up <= F) {
                    queue.offer(new int[]{up, cost+1});
                }

                if(down > 0) {
                    queue.offer(new int[]{down, cost+1});
                }

                visited[x] = true;
            }
        }

        System.out.print(answer == -1 ? noWay : answer);
        br.close();
    }
}
