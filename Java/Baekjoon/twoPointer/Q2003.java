package Baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2003 (수들의 합 2)
 * @classification: two-pointer
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.07.07 (O)
 **/
public class Q2003 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        br.close();

        int str = 0, end = 0;
        long sum = a[0];

        if(sum == n) {
            ++result;
        }

        while(str < m && end < m && str <= end) {
            if(str == end || sum <= n) {
                ++end;
                if(end == m) {
                    break;
                }

                sum += a[end];
            } else if(sum > n) {
                sum -= a[str];
                ++str;
            }

            if(sum == n) {
                ++result;
            }
        }

        System.out.print(result);
    }
}
