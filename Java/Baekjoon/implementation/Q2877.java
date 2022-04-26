package Baekjoon.implementation;

import java.io.*;

/**
 *@source: https://www.acmicpc.net/problem/2877 (4와 7)
 *@classfication: implementation
 *@reference: https://syh39.github.io/algorithm/algorithm_BOJ_2877/
 **/
public class Q2877 {
    public static void main(String[] args) throws IOException {
        // K+1을 이진수로 변환 후 가장 큰 자리 수를 제외한 뒤 0은 4, 1을 7로 변환 합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()) + 1;
        br.close();
        String kToBinary = Integer.toBinaryString(K);

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<kToBinary.length();i++) {
            if(kToBinary.charAt(i) == '0') sb.append('4');
            else if(kToBinary.charAt(i) == '1') sb.append('7');
        }

        System.out.print(sb);
    }
}
