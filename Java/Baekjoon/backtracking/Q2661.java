package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2661 (좋은수열)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.04.09(X, String 을 이용한 backtracking 아이디어를 떠올리지 못함)
 **/
public class Q2661 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
        backtracking("");
    }

    private static void backtracking(String str) {
        if(str.length() == N) {
            System.out.print(str);
            System.exit(0);

            return;
        }

        for(int i=1;i<4;i++) {
            if(validate(str+i))
                backtracking(str+i);
        }
    }

    private static boolean validate(String str) {
        for(int i=1;i<=str.length()/2;i++) {
            for(int j=0;j<=str.length()-i*2;j++) {
                if(str.substring(j, j+i).equals(str.substring(j+i, j+i*2)))
                    return false;
            }
        }
        return true;
    }
}
