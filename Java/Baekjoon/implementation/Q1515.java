package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/1515 (수 이어 쓰기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.02.17 (X)
 * @reference: https://www.acmicpc.net/board/view/98312 (반례)
 **/
public class Q1515 {
    public static void main(String[] args) throws IOException {
        int num = 1, pointer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        br.close();

        L1: while(pointer < n.length()) {
            String num_str = num + "";

            for(int i=0;i<num_str.length();i++) {
                if(n.charAt(pointer) == num_str.charAt(i)) {
                    ++pointer;

                    if(pointer == n.length())
                        break L1;
                }
            }

            ++num;
        }

        System.out.print(num);
    }
}
