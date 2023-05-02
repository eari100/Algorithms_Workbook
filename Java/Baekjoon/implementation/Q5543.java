package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/5543 (상근날드)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.05.02 (O)
 **/
public class Q5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int burger1 = Integer.parseInt(br.readLine());
        int burger2 = Integer.parseInt(br.readLine());
        int burger3 = Integer.parseInt(br.readLine());
        int drink1 = Integer.parseInt(br.readLine());
        int drink2 = Integer.parseInt(br.readLine());

        br.close();

        System.out.print(Math.min(Math.min(burger1, burger2), burger3) + Math.min(drink1, drink2) - 50);
    }
}
