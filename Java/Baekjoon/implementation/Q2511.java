package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/2511 (카드놀이)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.25 (O)
 **/
public class Q2511 {
    public static void main(String[] args) throws IOException {
        int aScore = 0, bScore = 0;
        int drawCnt = 0;
        char lastWinner = 'A';
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] aCards = makeCards(br.readLine());
        int[] bCards = makeCards(br.readLine());
        br.close();

        for(int i=0;i<aCards.length;i++) {
            if(aCards[i] == bCards[i]) {
                ++aScore;
                ++bScore;
                ++drawCnt;
            } else if(aCards[i] > bCards[i]) {
                aScore += 3;
                lastWinner = 'A';
            } else {
                bScore += 3;
                lastWinner = 'B';
            }
        }

        result.append(aScore).append(' ').append(bScore).append('\n');

        if(drawCnt == 10) {
            result.append('D');
        } else if(aScore > bScore) {
            result.append('A');
        } else if(aScore < bScore) {
            result.append('B');
        } else {
            result.append(lastWinner);
        }

        System.out.print(result);
    }

    private static int[] makeCards(String data) {
        return Arrays.stream(data.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
