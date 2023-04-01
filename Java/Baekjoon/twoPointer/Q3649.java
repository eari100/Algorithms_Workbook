package Baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/3649 (로봇 프로젝트)
 * @classfication: two-pointer
 * @문제 푼 날짜 (자력으로 풂?): 23.04.01 (O, 입력 더러운 문제)
 **/
public class Q3649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = null;

        while((string = br.readLine()) != null) {
            int 구멍의_너비 = Integer.parseInt(string) * 10_000_000;
            int legoCnt = Integer.parseInt(br.readLine());
            int[] legos = new int[legoCnt];
            StringBuilder answer = new StringBuilder();

            for(int i=0;i<legoCnt;i++) {
                legos[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(legos);

            int str = 0;
            int end = legoCnt - 1;

            while(str < end) {
                int sum = legos[str] + legos[end];
                if(sum == 구멍의_너비) {
                    answer.append("yes ").append(legos[str]).append(' ').append(legos[end]);
                    break;
                } else if(sum > 구멍의_너비) {
                    --end;
                } else if(sum < 구멍의_너비) {
                    ++str;
                }
            }

            string = null;
            System.out.println(answer.length() > 0 ? answer : "danger");
        }
    }
}
