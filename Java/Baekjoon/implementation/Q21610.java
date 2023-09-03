package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/21610 (마법사 상어와 비바라기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.09.03 (O, 좌표내 중첩 이동, 증가 같은 조건이 있을 때는 copy 할 것)
 **/
// todo: 리펙토링해볼 것
public class Q21610 {
    static int N;
    final static int[] nX = {0, -1, -1, -1, 0, 1, 1, 1};
    final static int[] nY = {-1, -1, 0, 1, 1, 1, 0, -1};
    static ArrayList<int[]> clouds = new ArrayList<>();
    static int[][] board;
    static boolean[][] boardClouds;
    static int[][] addWaters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        boardClouds = new boolean[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.add(new int[]{board.length - 1, 0});
        clouds.add(new int[]{board.length - 1, 1});
        clouds.add(new int[]{board.length - 2, 0});
        clouds.add(new int[]{board.length - 2, 1});
        boardClouds[board.length - 1][0] = true;
        boardClouds[board.length - 1][1] = true;
        boardClouds[board.length - 2][0] = true;
        boardClouds[board.length - 2][1] = true;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken()) - 1;
            int move = Integer.parseInt(st.nextToken());

            moveClouds(direction, move);

            addWaters = new int[N][N];

            for(int[] cloud : clouds)
                copyWater(cloud);

            for(int j=0;j<N;j++) {
                for (int k=0;k<N;k++) {
                    board[j][k] += addWaters[j][k];
                }
            }

            makeNewClouds();
        }

        br.close();

        System.out.print(sumWater());
    }

    private static void moveClouds(int direction, int move) {
        int addX = nX[direction] * move;
        int addY = nY[direction] * move;
        boolean[][] copyBoardClouds = new boolean[N][N];

        for(int i=0;i<clouds.size();i++) {
            int[] cloud = clouds.get(i);
            //boardClouds[cloud[0]][cloud[1]] = false;

            int remX = (cloud[0] + addX) % N;
            int remY = (cloud[1] + addY) % N;
            int x = 0, y = 0;

            if(remX < 0) {
                x = N + remX;
            } else {
                x = remX;
            }

            if(remY < 0) {
                y = N + remY;
            } else {
                y = remY;
            }

            int[] cloud2 = new int[]{x, y};
            copyBoardClouds[x][y] = true;
            clouds.set(i, cloud2);

            for(int j=0;j<N;j++) {
                for(int k=0;k<N;k++) {
                    boardClouds[j][k] = copyBoardClouds[j][k];
                }
            }

            addWater(cloud2, 1);
        }
    }

    private static void addWater(int[] cloud, int add) {
        board[cloud[0]][cloud[1]] += add;
    }

    private static void copyWater(int[] cloud) {
        int x1 = cloud[0];
        int y1 = cloud[1];
        int addWater = 0;

        for(int i=1;i<=7;i+=2) {
            int x2 = x1 + nX[i];
            int y2 = y1 + nY[i];

            if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= N)
                continue;

            if(isWater(new int[]{x2, y2}))
                ++addWater;
        }

        addWaters[x1][y1] = addWater;
    }

    private static boolean isWater(int[] cloud) {
        int water = board[cloud[0]][cloud[1]];

        return water > 0;
    }

    private static void makeNewClouds() {
        ArrayList<int[]> newClouds = new ArrayList<>();

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {

                if(boardClouds[i][j]) {
                    boardClouds[i][j] = false;
                    continue;
                }

                if(board[i][j] >= 2) {
                    board[i][j] -= 2;
                    boardClouds[i][j] = true;
                    newClouds.add(new int[]{i, j});
                }
            }
        }

        clouds = new ArrayList<>(newClouds);
    }

    private static int sumWater() {
        int sum = 0;

        for(int[] arr: board) {
            for(int i: arr) {
                sum += i;
            }
        }

        return sum;
    }
}
