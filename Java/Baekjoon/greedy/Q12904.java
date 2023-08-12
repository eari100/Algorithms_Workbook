package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/12904 (A와 B)
 * @classfication: greedy, string
 * @문제 푼 날짜 (자력으로 풂?): 23.08.12 (X)
 **/
public class Q12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        br.close();

        while(S.length() < T.length()) {
            int last = T.length() - 1;
            char chr = T.charAt(last);

            if(chr == 'A') {
                T.deleteCharAt(last);
            } else if(chr == 'B') {
                T.deleteCharAt(last);
                T.reverse();
            } else {
                break;
            }
        }

        System.out.print(S.equals(T.toString()) ? 1 : 0);
    }
}
