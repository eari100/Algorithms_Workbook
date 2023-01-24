package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/13604 (Jogo de Estratégia (전략 게임))
 *@classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.01.24 (O)
 **/
public class Q13604 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int J = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] playerScore = new int[J];
        int bestScore = 0;

        st = new StringTokenizer(br.readLine());

        br.close();

        for(int i=0;i<R;i++) {
            for(int j=0;j<J;j++) {
                bestScore = Math.max(bestScore, playerScore[j] += Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=J-1;i>-1;i--) {
            if(bestScore == playerScore[i]) {
                System.out.print(i+1);
                break;
            }
        }
    }
}
