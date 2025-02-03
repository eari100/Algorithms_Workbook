package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/16236 (아기 상어)
 * @classfication: implementation, bfs, priority queue
 * @문제 푼 날짜 (자력으로 풂?): 25.02.03 (X)
 **/
public class Q16236 {
    static int time = 0, size = 2, eat = 0;
    static int[] shark;
    final static int[][] moves = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static int[][] board;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<n;j++) {
                int obj = Integer.parseInt(st.nextToken());

                if(obj == 9) {
                    shark = new int[]{i, j};
                } else {
                    board[i][j] = obj;
                }
            }
        }

        br.close();

        while(moveShark()) {}

        System.out.print(time);
    }

    private static boolean moveShark() {
        visited = new int[board.length][board[0].length];
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (visited[o1[0]][o1[1]] != visited[o2[0]][o2[1]]) {
                return Integer.compare(visited[o1[0]][o1[1]], visited[o2[0]][o2[1]]);
            } else if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int init_x = shark[0], init_y = shark[1];
        q.add(new int[]{init_x, init_y});

        while( !q.isEmpty() ) {
            int[] poll = q.poll();
            int x1 = poll[0], y1 = poll[1];

            if(board[x1][y1] != 0 && size > board[x1][y1]) { // 잡아먹는다.
                eat++;
                time += visited[x1][y1];
                board[x1][y1] = 0;
                shark[0] = x1;
                shark[1] = y1;

                if(eat == size) {
                    size++;
                    eat = 0;
                }

                return true;
            }
            
            for(int[] move : moves) {
                int x2 = x1 + move[0], y2 = y1 + move[1];

                if(x2 < 0 || x2 >= board.length || y2 < 0 || y2 >= board[0].length) continue;
                if(x2 == init_x && y2 == init_y) continue; // init 자리에 방문 (이미 방문했다면)
                if(visited[x2][y2] > 0) continue; // 이미 방문했다면
                if(board[x2][y2] > size) continue; // 상대 물고기가 더 크다면

                visited[x2][y2] = visited[x1][y1] + 1;
                q.offer(new int[]{x2, y2});
            }
        }

        return false;
    }
}
