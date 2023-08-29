package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/3190 (뱀)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.29 (O)
 **/
public class Q3150 {
    static int[][] board;
    // right
    static int snakeDirection = 2;
    static ArrayList<int[]> snake = new ArrayList<>();
    static int playTime = 0;

    public static void main(String[] args) throws IOException {
        snake.add(new int[]{0 , 0});
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());


        board = new int[N][N];
        board[0][0] = 1;

        int k = Integer.parseInt(br.readLine());

        for(int i=0;i<k;i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            // apple
            board[x][y] = 9;
        }

        int L = Integer.parseInt(br.readLine());

        for(int i=0;i<L;i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());

            while(playTime < time) {
                move();
            }

            char spin = st.nextToken().charAt(0);
            changeDirection(spin);
        }

        while(true) {
            move();
        }
    }

    private static void move() {
        ++playTime;
        int[] next = next();
        int[] head = snake.get(snake.size() - 1);
        int nextX = head[0] + next[0];
        int nextY = head[1] + next[1];

        if(nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length)  {
            System.out.print(playTime);
            System.exit(0);
        }

        int nextObject = board[nextX][nextY];

        if(nextObject == 9) {

        } else if(nextObject == 0) {
            int[] tale = snake.get(0);
            board[tale[0]][tale[1]] = 0;
            snake.remove(0);
        } else if(nextObject == 1) {
            System.out.print(playTime);
            System.exit(0);
        }

        board[nextX][nextY] = 1;
        snake.add(new int[]{nextX, nextY});
    }

    private static void changeDirection(char spin) {
        if(spin == 'L') {
            --snakeDirection;

            if(snakeDirection == 0)
                snakeDirection = 4;
        } else if(spin == 'D') {
            ++snakeDirection;

            if(snakeDirection == 5)
                snakeDirection = 1;
        }
    }

    private static int[] next() {
        if(snakeDirection == 1) {
            return new int[]{-1, 0};
        } else if(snakeDirection == 2) {
            return new int[]{0, 1};
        } else if(snakeDirection == 3) {
            return new int[]{1, 0};
        } else if(snakeDirection == 4) {
            return new int[]{0, -1};
        }

        return new int[]{};
    }
}
