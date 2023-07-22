package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2174 (로봇 시뮬레이션)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.07.22 (O)
 **/
public class Q2174 {
    final static int[] nX = {0, 1, 0, -1};
    final static int[] nY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[][] board = new int[height][width];

        st = new StringTokenizer(br.readLine());

        int robotCount = Integer.parseInt(st.nextToken());
        int promptCount = Integer.parseInt(st.nextToken());

        Robot[] robots = new Robot[robotCount+1];
        StringBuilder result = new StringBuilder();

        for(int i=1;i<=robotCount;i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = getY(Integer.parseInt(st.nextToken()), height);
            board[y][x] = i;

            Direction direction = Direction.valueOf(st.nextToken());
            robots[i] = new Robot(direction.getIndex(), x, y);
        }

        L1: for(int i=0;i<promptCount;i++) {
            st = new StringTokenizer(br.readLine());

            int robotNo = Integer.parseInt(st.nextToken());
            String moveType = st.nextToken();
            int moveCount = Integer.parseInt(st.nextToken());
            Robot robot = robots[robotNo];

            if(moveType.equals("L")) {
                for(int j=0;j<moveCount;j++) {
                    --robot.direction;
                    if(robot.direction == -1) {
                        robot.direction = 3;
                    }
                }
            } else if(moveType.equals("R")) {
                for(int j=0;j<moveCount;j++) {
                    ++robot.direction;
                    if(robot.direction == 4) {
                        robot.direction = 0;
                    }
                }
            } else if(moveType.equals("F")) {
                for(int j=0;j<moveCount;j++) {
                    int nextX = robot.x + nX[robot.direction];
                    int nextY = robot.y + nY[robot.direction];

                    if(nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) {
                        result.append("Robot ").append(robotNo).append(" crashes into the wall");
                        break L1;
                    }

                    if(board[nextY][nextX] != 0) {
                        int crashedRobotNo = board[nextY][nextX];

                        result.append("Robot ").append(robotNo).append(" crashes into robot ").append(crashedRobotNo);
                        break L1;
                    }

                    board[robot.y][robot.x] = 0;
                    board[nextY][nextX] = robotNo;

                    robot.x = nextX;
                    robot.y = nextY;
                }
            }
        }

        br.close();

        System.out.print(result.length() == 0 ? "OK" : result);
    }

    private static int getY(int preY, int height) {
        return height - preY;
    }

    public static class Robot {
        int direction;
        int x;
        int y;

        public Robot(int direction, int x, int y) {
            this.direction = direction;
            this.x = x;
            this.y = y;
        }
    }

    enum Direction {
        N(0),
        E(1),
        S(2),
        W(3);

        private final int index;

        private Direction(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
}
