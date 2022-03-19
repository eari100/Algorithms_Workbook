package Baekjoon.Q1676;

import java.io.*;
/**
 *@source: https://www.acmicpc.net/problem/1676 (팩토리얼 0의 개수)
 *@classfication: math
 *@reference: https://st-lab.tistory.com/165
 **/
public class UsingOfficial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int N = Integer.parseInt(br.readLine());
        br.close();

        while(N>=5) {
            result += N/5;
            N/=5;
        }

        System.out.print(result);
    }
}
