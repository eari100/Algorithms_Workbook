package Baekjoon.bruteforce.Q14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14889 (스타트와 링크)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.29 (O)
 * @reference: https://www.acmicpc.net/source/58349778 (더 효율적인 방법)
 **/
public class D230429 {
    static boolean[] startTeam;
    static int[][] board;
    static int minGapPower = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        startTeam = new boolean[N];

        for(int i=0;i<N;i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(row.nextToken());
            }
        }

        br.close();

        getStartTeam(1, N, 0);

        System.out.print(minGapPower);
    }

    private static void getStartTeam(int depth, int humanCnt, int startIndex) {
        if(depth > humanCnt/2) {
            minGapPower = Math.min(minGapPower, getGapPower());

            return;
        }

        for(int i=startIndex;i<humanCnt;i++) {
            if(!startTeam[i]) {
                startTeam[i] = true;
                getStartTeam(depth+1, humanCnt, i+1);
                startTeam[i] = false;
            }
        }
    }

    private static int getGapPower() {
        int startTeamPower = 0;
        int linkTeamPower = 0;

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                if (startTeam[i] && startTeam[j]) {
                    startTeamPower += board[i][j];
                }

                if(!startTeam[i] && !startTeam[j]) {
                    linkTeamPower += board[i][j];
                }
            }
        }

        return Math.abs(startTeamPower - linkTeamPower);
    }
}
