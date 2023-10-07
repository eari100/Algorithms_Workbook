package Baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/2470 (두 용액)
 * @classfication: two pointer
 * @문제 푼 날짜 (자력으로 풂?): 23.10.07 (O)
 **/
public class Q2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] waters = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        Arrays.sort(waters);

        int str = 0;
        int end = N-1;
        int diff = 2_000_000_000;
        String result = "";

        while(str < end) {
            int mid = waters[str] + waters[end];

            if(diff > Math.abs(mid)) {
                diff = Math.abs(mid);
                result = waters[str] + " " + waters[end];
            }

            if(mid < 0) {
                ++str;
            } else if(mid > 0) {
                --end;
            } else {
                break;
            }
        }

        System.out.print(result);
        br.close();
    }
}
