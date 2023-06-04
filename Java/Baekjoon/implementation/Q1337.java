package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @source: https://www.acmicpc.net/problem/1337 (올바른 배열)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.05.03 (O)
 **/
public class Q1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 4;

        HashSet<Integer> numList = new HashSet<>();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            numList.add(num);
        }

        br.close();

        for(int num : numList) {
            int needElement = 0;

            for(int i=1;i<5;i++) {
                if(!numList.contains(num + i)) {
                    ++needElement;
                }
            }

            result = Math.min(result, needElement);
        }

        System.out.print(result);
    }
}
