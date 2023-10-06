package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11123 {
    static final int[] nX = {-1, 1, 0, 0};
    static final int[] nY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char[][] board = new char[x][y];
            boolean[][] visited = new boolean[x][y];
            int count = 0;

            for(int j=0;j<x;j++) {
                String row = br.readLine();

                for(int k=0;k<row.length();k++) {
                    board[j][k] = row.charAt(k);
                }
            }

            for(int j=0;j<board.length;j++) {
                for(int k=0;k<board[0].length;k++) {
                    if( !visited[j][k] && board[j][k] == '#' ) {
                        visited[j][k] = true;
                        ++count;
                        bfs(j, k, board, visited);
                    }
                }
            }

            result.append(count).append('\n');
        }

        System.out.print(result);
        br.close();
    }

    private static void bfs(int x, int y, char[][] board, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];

            for(int i=0;i<nX.length;i++) {
                int x2 = x1 + nX[i];
                int y2 = y1 + nY[i];

                if(x2 < 0 || x2 >= board.length || y2 < 0 || y2 >= board[0].length)
                    continue;

                if(visited[x2][y2])
                    continue;

                if(board[x2][y2] == '.')
                    continue;

                visited[x2][y2] = true;
                queue.add(new int[]{x2, y2});
            }
        }
    }
}
