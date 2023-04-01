package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/5052 (전화번호 목록)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.01 (X, String sort 의 결과값, String.startWith)
 * @reference: https://steady-coding.tistory.com/78
 **/
public class Q5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            String answer = "YES";
            int numberCnt = Integer.parseInt(br.readLine());
            String[] numbers = new String[numberCnt];

            for(int j=0;j<numberCnt;j++)
                numbers[j] = br.readLine();

            Arrays.sort(numbers);

            for(int j=numbers.length-1;j>0;j--) {
                if(numbers[j].startsWith(numbers[j-1])) {
                    answer = "NO";
                    break;
                }
            }

            result.append(answer).append('\n');
        }

        System.out.print(result);
    }
}
