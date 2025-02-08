package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/2636 (치즈)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.02.09 (O)
 **/
public class Q2636 {
    static final int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[n][m]; // 외부 연결 치즈, empty
        int[][] board = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> tempQ = new LinkedList<>();
        int count = 0;
        int prevCount = count;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<m;j++) {
                int obj = Integer.parseInt(st.nextToken());
                board[i][j] = obj;

                if(obj == 0) {
                    if(i == 0 || i == n-1 || j ==  0 || j == m-1) {
                        q.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                } else {
                    ++count;
                }
            }
        }

        while( !q.isEmpty() ) {
            int[] poll = q.poll();

            for(int[] move : moves) {
                int x = poll[0] + move[0];
                int y = poll[1] + move[1];

                if(x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }

                if(visited[x][y]) continue;

                visited[x][y] = true;

                if(board[x][y] == 1) {
                    tempQ.offer(new int[]{x, y});
                } else {
                    q.offer(new int[]{x, y});
                }
            }
        }

        while( !tempQ.isEmpty() ) {
            q.offer(tempQ.poll());
        }

        int time = 0;
        while(count > 0) {
            time++;
            prevCount = count;

            while( !q.isEmpty() ) {
                int[] poll = q.poll();

                for(int[] move : moves) {
                    int x = poll[0] + move[0];
                    int y = poll[1] + move[1];

                    if(x < 0 || x >= n || y < 0 || y >= m) {
                        continue;
                    }

                    if(visited[x][y]) continue;
                    visited[x][y] = true;

                    if(board[x][y] == 1) {
                        tempQ.offer(new int[]{x, y});
                    } else {
                        Queue<int[]> q3 = new LinkedList<>();
                        q3.offer(new int[]{x, y});

                        while( !q3.isEmpty() ) {
                            int[] poll2 = q3.poll();

                            for(int[] move2 : moves) {
                                int x2 = poll2[0] + move2[0];
                                int y2 = poll2[1] + move2[1];

                                if(x2 < 0 || x2 >= n || y2 < 0 || y2 >= m) {
                                    continue;
                                }

                                if(visited[x2][y2]) continue;

                                visited[x2][y2] = true;

                                if(board[x2][y2] == 0) {
                                    q3.offer(new int[]{x2, y2});
                                } else {
                                    tempQ.offer(new int[]{x2, y2});
                                }
                            }
                        }
                    }
                }

                --count;
                board[poll[0]][poll[1]] = 0;
            }

            while( !tempQ.isEmpty() ) {
                q.offer(tempQ.poll());
            }
        }

        br.close();

        System.out.println(time);
        System.out.println(prevCount);
    }
}
