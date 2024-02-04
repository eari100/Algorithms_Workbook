package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/29733 (3차원 지뢰찾기)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.02.04 (O)
 **/
public class Q29733 {
    static final char mine = '*', empty = '.';

    static final int[] move = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int set = Integer.parseInt(st.nextToken());

        char[][][] board = new char[set][h][w];
        ArrayList<int[]> emptyList = new ArrayList<>();

        for(int i=0;i<set;i++) {
            for(int j=0;j<h;j++) {
                String row = br.readLine();

                for(int k=0;k<w;k++) {
                    char obj = row.charAt(k);

                    board[i][j][k] = obj;

                    if(obj == empty) {
                        emptyList.add(new int[]{i,j,k});
                    }
                }
            }
        }

        br.close();

        for(int[] e : emptyList) {
            int mineCnt = 0;

            for(int i=0;i<move.length;i++) {
                for(int j=0;j<move.length;j++) {
                    for(int k=0;k< move.length;k++) {
                        int x = e[0]+move[i];
                        int y = e[1]+move[j];
                        int z = e[2]+move[k];

                        if(x < 0 || x >= set || y < 0 || y >= h || z < 0 || z >= w)
                            continue;

                        if(board[x][y][z] == mine)
                            ++mineCnt;
                    }
                }
            }

            board[e[0]][e[1]][e[2]] = Integer.toString(mineCnt%10).charAt(0);
        }

        StringBuilder result = new StringBuilder();

        for(int i=0;i<set;i++) {
            for(int j=0;j<h;j++) {
                for(int k=0;k<w;k++) {
                    result.append(board[i][j][k]);
                }

                result.append('\n');
            }
        }

        System.out.print(result);
    }
}
