package Baekjoon.dp.Q1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopDown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        br.close();
        System.out.print(dp(X, 0));
    }

    private static int dp(int X, int count) {
        if(X<2) return count;
        return Math.min(dp(X/2, count+1+(X%2)), dp(X/3, count+1+(X%3)));
    }
}
