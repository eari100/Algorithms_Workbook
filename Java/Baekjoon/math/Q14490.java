package Baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/14490 (백대열)
 * @classification: math
 * @문제 푼 날짜 (자력솔?): 25.02.14 (O)
 **/
// todo: 최대 공약수로 나눠주기
public class Q14490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        L1: while(true) {
            for(int i=2;i<=100_000_000;i++) {
                if(i > arr[0] || i > arr[1]) break L1;

                if(arr[0] % i == 0 && arr[1] % i == 0) {
                    arr[0] /= i;
                    arr[1] /= i;
                    break;
                }
            }
        }

        br.close();

        System.out.println(arr[0]+":"+arr[1]);
    }
}
