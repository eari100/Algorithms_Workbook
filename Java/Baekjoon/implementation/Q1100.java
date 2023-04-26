package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/1100 (하얀 칸)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.26 (O)
 **/
public class Q1100 {
    public static void main(String[] args) throws IOException {
        int whiteSpaceCnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=1;i<9;i++) {
            String row = br.readLine();

            if(i % 2 == 0) {
                int[] whiteSpaces = {2, 4, 6, 8};

                for(int whiteSpace : whiteSpaces) {
                    if(row.charAt(whiteSpace-1) == 'F') ++whiteSpaceCnt;
                }
            } else {
                int[] whiteSpaces = {1, 3, 5, 7};

                for(int whiteSpace : whiteSpaces) {
                    if(row.charAt(whiteSpace-1) == 'F') ++whiteSpaceCnt;
                }
            }
        }
        br.close();

        System.out.print(whiteSpaceCnt);
    }
}
