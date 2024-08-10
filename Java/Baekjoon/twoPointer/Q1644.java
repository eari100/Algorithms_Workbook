package Baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @source: https://www.acmicpc.net/problem/1644 (소수의 연속합)
 * @classification: two pointer
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.10 (소수 판정 알고리즘 참고)
 **/
public class Q1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        ArrayList<Integer> primaryList = new ArrayList<>();

        for(int i=2;i<=n;i++) {
            boolean isPrimary = true;

            for(int j=2;j<=Math.sqrt(i);j++) {
                if(i % j == 0) {
                    isPrimary = false;
                    break;
                }
            }

            if(isPrimary) {
                primaryList.add(i);
            }
        }

        int answer = 0;

        if(n > 1) {
            long sum = primaryList.get(0);
            int str = 0, end = 0;

            while(str <= end) {
                if(sum == n) {
                    ++answer;
                }

                if(sum <= n) {
                    ++end;

                    if(end >= primaryList.size()) {
                        break;
                    }

                    sum += primaryList.get(end);
                } else if(sum > n) {
                    sum -= primaryList.get(str);
                    ++str;
                }
            }
        }

        System.out.print(answer);
    }
}
