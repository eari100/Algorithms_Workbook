package Baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/2467 (용액)
 * @classfication: two pointer
 * @문제 푼 날짜 (자력으로 풂?): 23.08.24 (X)
 **/
public class Q2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();

        int str = 0;
        int end = arr.length - 1;
        int tmpStr = arr[str];
        int tmpEnd = arr[end];
        long min = Math.abs(tmpStr + tmpEnd);

        while(str < end) {
            long sum = arr[str] + arr[end];

            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                tmpStr = arr[str];
                tmpEnd = arr[end];
            }

            if(sum == 0) {
                break;
            } else if(sum < 0) {
                ++str;
            } else if(sum > 0) {
                --end;
            }
        }

        System.out.print(tmpStr + " " + tmpEnd);
    }
}
