package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/12100 (2048 (Easy))
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 24.06.25 (O)
 **/
public class Q12100 {
    static int maxNum = 0;
    static boolean[][] mergeCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++) {
                int num = Integer.parseInt(st.nextToken());
                maxNum = Math.max(maxNum, num);
                board[i][j] = num;
            }
        }

        br.close();

        bt(0, board);

        System.out.print(maxNum);
    }

    private static void bt(int depth, int[][] board) {
        if(depth == 5) {
            return;
        }

        int N = board.length;

        for(int d=0;d<4;d++) {
            int[][] copyOfBoard = deepCopy(board);
            boolean isMove = false;
            mergeCheck = new boolean[N][N];

            if(d == 0) {
                for(int i=0;i<N;i++) {
                    for(int j=0;j<N;j++) {
                        if(copyOfBoard[i][j] == 0) continue;

                        int currX = i, currY = j;
                        int curr = copyOfBoard[currX][currY];

                        while(currX > 0) {
                            int nextX = currX-1, nextY = currY;
                            int next = copyOfBoard[nextX][nextY];

                            if(next == 0) {
                                isMove = true;
                                copyOfBoard[nextX][nextY] = curr;
                                copyOfBoard[currX][currY] = 0;
                            } else {
                                if(mergeCheck[nextX][nextY]) {
                                    break;
                                }

                                if(curr == next) {
                                    isMove = true;
                                    copyOfBoard[nextX][nextY] *= 2;

                                    maxNum = Math.max(maxNum, copyOfBoard[nextX][nextY]);
                                    copyOfBoard[currX][currY] = 0;
                                    mergeCheck[nextX][nextY] = true;
                                    break;
                                } else {
                                    break;
                                }
                            }

                            currX -= 1;
                        }
                    }
                }

                if(isMove)
                    bt(depth+1, copyOfBoard);
            } else if(d == 1) {
                for(int i=0;i<N;i++) {
                    for(int j=N-1;j>=0;j--) {
                        if(copyOfBoard[i][j] == 0) continue;

                        int currX = i, currY = j;
                        int curr = copyOfBoard[currX][currY];

                        while(currY < N-1) {
                            int nextX = currX, nextY = currY+1;
                            int next = copyOfBoard[nextX][nextY];

                            if(next == 0) {
                                isMove = true;
                                copyOfBoard[nextX][nextY] = curr;
                                copyOfBoard[currX][currY] = 0;
                            } else {
                                if(mergeCheck[nextX][nextY]) {
                                    break;
                                }

                                if(curr == next) {
                                    isMove = true;
                                    copyOfBoard[nextX][nextY] *= 2;

                                    maxNum = Math.max(maxNum, copyOfBoard[nextX][nextY]);
                                    copyOfBoard[currX][currY] = 0;
                                    mergeCheck[nextX][nextY] = true;
                                    break;
                                } else {
                                    break;
                                }
                            }

                            currY += 1;
                        }
                    }
                }

                if(isMove)
                    bt(depth+1, copyOfBoard);
            } else if(d == 2) {
                for(int i=N-1;i>=0;i--) {
                    for(int j=0;j<N;j++) {
                        if(copyOfBoard[i][j] == 0) continue;

                        int currX = i, currY = j;
                        int curr = copyOfBoard[currX][currY];

                        while(currX < N-1) {
                            int nextX = currX+1, nextY = currY;
                            int next = copyOfBoard[nextX][nextY];

                            if(next == 0) {
                                isMove = true;
                                copyOfBoard[nextX][nextY] = curr;
                                copyOfBoard[currX][currY] = 0;
                            } else {
                                if(mergeCheck[nextX][nextY]) {
                                    break;
                                }

                                if(curr == next) {
                                    isMove = true;
                                    copyOfBoard[nextX][nextY] *= 2;

                                    maxNum = Math.max(maxNum, copyOfBoard[nextX][nextY]);
                                    copyOfBoard[currX][currY] = 0;
                                    mergeCheck[nextX][nextY] = true;
                                    break;
                                } else {
                                    break;
                                }
                            }

                            currX += 1;
                        }
                    }
                }

                if(isMove)
                    bt(depth+1, copyOfBoard);
            } else if(d == 3) {
                for(int i=0;i<N;i++) {
                    for(int j=0;j<N;j++) {
                        if(copyOfBoard[i][j] == 0) continue;

                        int currX = i, currY = j;
                        int curr = copyOfBoard[currX][currY];

                        while(currY > 0) {
                            int nextX = currX, nextY = currY-1;
                            int next = copyOfBoard[nextX][nextY];

                            if(next == 0) {
                                isMove = true;
                                copyOfBoard[nextX][nextY] = curr;
                                copyOfBoard[currX][currY] = 0;
                            } else {
                                if(mergeCheck[nextX][nextY]) {
                                    break;
                                }

                                if(curr == next) {
                                    isMove = true;
                                    copyOfBoard[nextX][nextY] *= 2;

                                    maxNum = Math.max(maxNum, copyOfBoard[nextX][nextY]);
                                    copyOfBoard[currX][currY] = 0;
                                    mergeCheck[nextX][nextY] = true;
                                    break;
                                } else {
                                    break;
                                }
                            }

                            currY -= 1;
                        }
                    }
                }

                if(isMove)
                    bt(depth+1, copyOfBoard);
            }
        }
    }

    private static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][];

        for (int i = 0; i < original.length; i++) {
            copy[i] = new int[original[i].length];
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }

        return copy;
    }
}
