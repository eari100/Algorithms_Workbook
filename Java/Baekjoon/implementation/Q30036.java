package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/30036 (INK)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.02.03 (O)
 **/
public class Q30036 {
    static char[] color;
    static char[][] board;
    static char[] command;
    static int[] boxLocation = new int[2];
    static final char box = '@', empty = '.', cmdChargeInk = 'j', cmdChargeJump = 'J';
    static int inkPower = 0, colorOrder = 0;
    static final int[] nX = {-1, 1, 0, 0}, nY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int colorLen = Integer.parseInt(st.nextToken());
        int boardLen = Integer.parseInt(st.nextToken());
        int commandLen = Integer.parseInt(st.nextToken());

        color = br.readLine().toCharArray();
        board = new char[boardLen][boardLen];

        for(int i=0;i<boardLen;i++) {
            String row = br.readLine();

            for(int j=0;j<boardLen;j++) {
                char obj = row.charAt(j);
                board[i][j] = obj;

                if(obj == box) {
                    boxLocation[0] = i;
                    boxLocation[1] = j;
                }
            }
        }

        command = br.readLine().toCharArray();

        br.close();

        for(char c : command) {
            if(c == cmdChargeInk) {
                chargeInk();
            } else if(c == cmdChargeJump) {
                jump();
            } else {
                moveBox(c);
            }
        }

        StringBuilder result = new StringBuilder();

        for(char[] arr: board) {
            for(char c: arr) {
                result.append(c);
            }

            result.append('\n');
        }

        System.out.print(result);
    }

    private static void moveBox(char move) {
        int newBoxX, newBoxY;

        if(move == 'U') {
            newBoxX = boxLocation[0] - 1;
            newBoxY = boxLocation[1];
        } else if(move == 'D') {
            newBoxX = boxLocation[0] + 1;
            newBoxY = boxLocation[1];
        } else if(move == 'L') {
            newBoxX = boxLocation[0];
            newBoxY = boxLocation[1] - 1;
        } else if(move == 'R') {
            newBoxX = boxLocation[0];
            newBoxY = boxLocation[1] + 1;
        } else {
            return; // Unexpected move character
        }

        if (!isMove(newBoxX, newBoxY))
            return;

        move(newBoxX, newBoxY);
        boxLocation[0] = newBoxX;
        boxLocation[1] = newBoxY;
    }

    private static void chargeInk() {
        ++inkPower;
    }

    private static void jump() {
        if(inkPower == 0)  {
            ++colorOrder;
            return;
        }

        bfs();

        inkPower = 0;
        ++colorOrder;
    }

    private static void bfs() {
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[boxLocation[0]][boxLocation[1]] = true;
        char c = color[colorOrder % color.length];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{boxLocation[0], boxLocation[1], inkPower});

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], m = poll[2];

            for(int i=0;i<nX.length;i++) {
                int x2 = x + nX[i], y2 = y + nY[i], m2 = m-1;

                if(isOut(x2, y2))
                    continue;

                if(visited[x2][y2])
                    continue;

                if(isObstacle(x2, y2)) {
                    board[x2][y2] = c;
                }

                visited[x2][y2] = true;

                if(m2 > 0)
                    queue.offer(new int[]{x2, y2, m2});
            }
        }
    }

    private static boolean isMove(int x, int y) {
        if(isOut(x, y))
            return false;

        return !isObstacle(x, y);
    }

    private static void move(int x, int y) {
        board[boxLocation[0]][boxLocation[1]] = empty;
        board[x][y] = box;
    }

    private static boolean isObstacle(int x, int y) {
        return board[x][y] != empty;
    }

    private static boolean isOut(int x, int y) {
        return x < 0 || x >= board.length || y < 0 || y >= board[0].length;
    }
}
