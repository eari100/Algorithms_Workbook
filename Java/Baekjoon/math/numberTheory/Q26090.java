package Baekjoon.math.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/26090 (완전한 수열)
 * @classification: number theory
 * @문제 푼 날짜 (자력으로 풂?): 24.11.11 (O)
 **/
// todo: 누적합 적용
public class Q26090 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int primeCnt = 0;

        for(int i=0;i<n-1;i++) {
            int sum = 0;
            int cnt = 0;
            for(int j=i;j<n;j++) {
                sum += arr[j];
                cnt++;

                if(isPrime(cnt) && isPrime(sum)) {
                    ++primeCnt;
                }
            }
        }

        System.out.print(primeCnt);
    }

    private static boolean isPrime(int n) {
        if(n <= 1) return false;

        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
