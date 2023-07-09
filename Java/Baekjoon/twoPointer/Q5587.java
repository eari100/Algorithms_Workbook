package Baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/5587 (카드 캡터 상근이)
 * @classfication: two-pointer
 * @문제 푼 날짜 (자력으로 풂?): 23.07.10 (O)
 **/
public class Q5587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cardCnt = Integer.parseInt(br.readLine());
        boolean[] cards = new boolean[(cardCnt * 2) + 1];
        boolean[] used = new boolean[(cardCnt * 2) + 1];

        for (int i = 0; i < cardCnt; i++) {
            int card = Integer.parseInt(br.readLine());
            cards[card] = true;
        }

        br.close();

        boolean 상근Turn = true;
        int 근상Score = cardCnt, 상근Score = cardCnt;
        int min = 0;

        while (근상Score > 0 && 상근Score > 0) {
            if (상근Turn) {
                boolean flag = false;
                for (int i = min + 1; i < cards.length; i++) {
                    if (cards[i] && !used[i]) {
                        used[i] = true;
                        min = i;
                        --근상Score;
                        flag = true;
                        break;
                    }
                }

                if(!flag) min = 0;

            } else {
                if (!상근Turn) {
                    boolean flag = false;
                    for (int i = min + 1; i < cards.length; i++) {
                        if (!cards[i] && !used[i]) {
                            used[i] = true;
                            min = i;
                            --상근Score;
                            flag = true;
                            break;
                        }
                    }

                    if(!flag) min = 0;
                }
            }

            상근Turn = !상근Turn;
        }

        System.out.println(상근Score);
        System.out.println(근상Score);
    }
}
