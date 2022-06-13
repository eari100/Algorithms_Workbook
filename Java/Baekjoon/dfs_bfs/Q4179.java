package Baekjoon.dfs_bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/4179
 * @classfication: bfs
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.14 (X, 반례를 찾지 못함)
 **/
public class Q4179 {
    static int R;
    static int C;
    static char[][] graph;
    static Queue<int[]> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        queue = new LinkedList<>();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        int x = 0;
        int y = 0;

        for(int i=0;i<R;i++) {
            String row = br.readLine();

            for(int j=0;j<C;j++) {
                char c = row.charAt(j);
                if(c == 'F') {
                    queue.offer(new int[]{i, j});
                } else if(c == 'J') {
                    x = i;
                    y = j;
                }
                graph[i][j] = c;
            }
        }
        queue.offer(new int[]{x, y, 1});

        br.close();

        // 가장자리에 사람이 있을 경우
        if(x == 0 || x == R-1 || y == 0 || y == C-1) System.out.println(1);
        else {
            int time = bfs();
            System.out.print(time == 0 ? "IMPOSSIBLE" : time);
        }
    }

    private static int bfs() {
        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();

            if(poll.length == 3) {
                for(int i=0;i<4;i++) {
                    int nx = poll[0] + dx[i];
                    int ny = poll[1] + dy[i];
                    int time = poll[2];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C || graph[nx][ny] != '.') continue;

                    if(nx == 0 || nx == R-1 || ny == 0 || ny == C-1) return time+1;
                    else {
                        graph[nx][ny] = 'J';
                        queue.offer(new int[]{nx, ny, time+1});
                    }
                }
            } else {
                for(int i=0;i<4;i++) {
                    int nx = poll[0] + dx[i];
                    int ny = poll[1] + dy[i];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                    if(graph[nx][ny] != '#' && graph[nx][ny] != 'F') {
                        graph[nx][ny] = 'F';
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return 0;
    }
}
