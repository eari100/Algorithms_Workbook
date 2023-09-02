package Atcoder.AtCoder_Beginner_contest_318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://atcoder.jp/contests/abc318/tasks/abc318_a (A - Full Moon)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.09.02 (O)
 **/
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        br.close();

        int result = 0;

        for(int i=M;i<=N;i++) {
            if((i-M) % P == 0) {
                ++result;
            }
        }

        System.out.print(result);
    }
}
