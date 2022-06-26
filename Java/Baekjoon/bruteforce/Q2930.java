package Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2930 (가위 바위 보)
 * @classfication: bruteforce
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.26 (O, bruteforce 가 최고의 효율이 될 수 있는 경우의 문제)
 **/
public class Q2930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        int bestScore = 0;

        int matchCnt = Integer.parseInt(br.readLine());
        char[] myLogs = new char[matchCnt];

        String myLogStr = br.readLine();
        for(int i=0;i<matchCnt;i++)
            myLogs[i] = myLogStr.charAt(i);

        int enemyCnt = Integer.parseInt(br.readLine());

        char[][] enemyLogs = new char[enemyCnt][matchCnt];

        for(int i=0;i<enemyCnt;i++) {
            String enemyLogStr = br.readLine();
            for(int j=0;j<matchCnt;j++) {
                char enemyHand = enemyLogStr.charAt(j);
                score += calculateScore(myLogs[j], enemyHand);
                enemyLogs[i][j] = enemyHand;
            }
        }
        br.close();

        for(int i=0;i<matchCnt;i++) {
            int sHandSum = 0;
            int rHandSum = 0;
            int pHandSum = 0;
            int biggestSum = 0;

            for(int j=0;j<enemyCnt;j++) {
                sHandSum += calculateScore('S', enemyLogs[j][i]);
                rHandSum += calculateScore('R', enemyLogs[j][i]);
                pHandSum += calculateScore('P', enemyLogs[j][i]);
            }
            biggestSum = sHandSum;
            biggestSum = Math.max(biggestSum, rHandSum);
            biggestSum = Math.max(biggestSum, pHandSum);

            bestScore += biggestSum;
        }

        System.out.println(score);
        System.out.println(bestScore);
    }

    private static int calculateScore(char myHand, char enemyHand) {
        if(myHand == enemyHand) return 1;

        if(myHand == 'R') {
            return enemyHand == 'S' ? 2 : 0;
        } else if(myHand == 'S') {
            return enemyHand == 'P' ? 2 : 0;
        } else if(myHand == 'P') {
            return enemyHand == 'R' ? 2 : 0;
        }

        return -1;
    }
}
