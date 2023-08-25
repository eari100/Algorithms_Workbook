package Atcoder.AtCoder_Beginner_Contest_314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://atcoder.jp/contests/abc314/tasks/abc314_a (A - 3.14)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.26 (O)
 **/
public class A {
    public static void main(String[] args) throws IOException {
        String PI = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        System.out.print(PI.substring(0, N + 2));
    }
}
