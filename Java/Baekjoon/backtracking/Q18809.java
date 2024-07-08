package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/18809 (Gaaaaaaaaaarden)
 * @classification: backtracking
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.07.08 (X)
 **/
public class Q18809 {
    static int[][] board;
    static int maxFlowerCnt = 0;
    static ArrayList<int[]> cultivable = new ArrayList<>();
    static final int FLOWER = 5100;
    static final int WATER = 5200;
    static final int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()), g = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<m;j++) {
                int obj = Integer.parseInt(st.nextToken());  // 0: 호수, 1: 배양x, 2: 배양o

                if(obj == 0) {
                    board[i][j] = WATER;
                } else if(obj == 2) {
                    cultivable.add(new int[]{i, j});
                }
            }
        }

        br.close();

        bt(0, r, g);

        System.out.print(maxFlowerCnt);
    }

    private static void bt(int depth, int r, int g) {
        if(depth == cultivable.size()) {
            if(r == 0 && g == 0) {
                int[][] copyBoard = new int[board.length][board[0].length];

                for(int i=0;i<board.length;i++) {
                    for(int j=0;j<board[0].length;j++) {
                        copyBoard[i][j] = board[i][j];
                    }
                }

                maxFlowerCnt = Math.max(maxFlowerCnt, bfs(copyBoard));
            }

            return;
        }

        int[] location = cultivable.get(depth);
        int x = location[0], y = location[1];

        if(r > 0) {
            board[x][y] = 1;
            bt(depth+1, r-1, g);
            board[x][y] = 0;
        }

        if(g > 0) {
            board[x][y] = -1;
            bt(depth+1, r, g-1);
            board[x][y] = 0;
        }

        bt(depth+1, r, g);
    }

    private static int bfs(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] loc : cultivable) {
            if (board[loc[0]][loc[1]] != 0) {
                queue.add(loc);
            }
        }

        int flowerCnt = 0;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];

            if(board[x][y] == FLOWER) continue;

            int seed = board[x][y];

            for(int[] move : moves) {
                int x2 = x + move[0], y2 = y + move[1];

                if( x2 < 0 || x2 >= board.length || y2 < 0 || y2 >= board[0].length ) continue;
                if(board[x2][y2] == WATER) continue;

                int seed2 = seed > 0 ? seed + 1 : seed - 1;

                if(board[x2][y2] == 0) {
                    board[x2][y2] = seed2;
                    queue.offer(new int[]{x2, y2});
                } else if(seed2 == -board[x2][y2]) {
                    board[x2][y2] = FLOWER;
                    ++flowerCnt;
                }
            }
        }

        return flowerCnt;
    }
}
