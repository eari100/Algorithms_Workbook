package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14716 {
    final static int[][] moves = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[h][w];
        boolean[][] visited = new boolean[h][w];
        int answer = 0;

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < w; j++) {
                String obj = st.nextToken();

                if(obj.equals("1"))
                    board[i][j] = true;
            }
        }

        br.close();

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if( !visited[i][j] && board[i][j]) {
                    ++answer;
                    bfs(board, visited, i, j);
                }
            }
        }

        System.out.print(answer);
    }

    private static void bfs(boolean[][] board, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x1 = poll[0], y1 = poll[1];

            for(int[] move : moves) {
                int x2 = x1 + move[0], y2 = y1 + move[1];

                if(x2 < 0 || x2 >= board.length || y2 < 0 || y2 >= board[0].length) continue;
                if(visited[x2][y2]) continue;
                if( !board[x2][y2] ) continue;
                visited[x2][y2] = true;

                queue.add(new int[]{x2, y2});
            }
        }
    }
}
