package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14709 (여우 사인)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.11.12 (O)
 **/
public class Q14709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        boolean oneThree = false, fourThree = false, oneFour = false;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            if(a == 1 && b == 3 || a == 3 && b == 1) {
                oneThree = true;
            } else if(a == 4 && b == 3 || a == 3 && b == 4) {
                fourThree = true;
            } else if(a == 1 && b == 4 || a == 4 && b == 1) {
                oneFour = true;
            } else {
                System.out.print("Woof-meow-tweet-squeek");
                return;
            }
        }

        br.close();

        if(oneThree && fourThree && oneFour) {
            System.out.print("Wa-pa-pa-pa-pa-pa-pow!");
        } else {
            System.out.print("Woof-meow-tweet-squeek");
        }
    }
}
