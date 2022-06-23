package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/17202 (핸드폰 번호 궁합)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.23 (O, 이게 dp 라는 생각이 들 정도로 너무 쉬운 문제 그냥 단순 구현인듯)
 **/
public class Q17202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        br.close();

        StringBuilder merge = new StringBuilder();

        for(int i=0;i<A.length();i++) {
            merge.append(A.charAt(i)).append(B.charAt(i));
        }

        while(merge.length()>2) {
            StringBuilder nextMerge = new StringBuilder();
            for(int i=1;i<merge.length();i++) {
                int a = Character.getNumericValue(merge.charAt(i));
                int b = Character.getNumericValue(merge.charAt(i - 1));
                int sum = a+b < 10 ? a+b : a+b-10;
                nextMerge.append(sum);
            }
            merge = nextMerge;
        }

        System.out.print(merge);
    }
}
