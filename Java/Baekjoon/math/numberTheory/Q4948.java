package Baekjoon.math.numberTheory;

import java.io.*;

/**
 * @source: https://www.acmicpc.net/problem/4948 (베르트랑 공준)
 * @classfication: number theory, 에라토스테네스의 체
 * @문제 푼 날짜 (자력으로 풂?): 23.12.10 (힌트 스포당하고 풀었으나 에라토스테네스의 체를 이상한 방식으로 사용함 다시풀ㅇ자)
 **/
public class Q4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                break;
            }

            int primeCnt = (2*num)-num;
            boolean[] memo = new boolean[2*num+1];

            for(int i=2;i<=Math.sqrt(2*num);i++) {
                for(int j=i*i;j<=2*num;j+=i) {
                    if(memo[j]) continue;

                    if(j > num) {
                        --primeCnt;
                    }

                    memo[j] = true;
                }
            }

            bw.write(String.valueOf(primeCnt));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
