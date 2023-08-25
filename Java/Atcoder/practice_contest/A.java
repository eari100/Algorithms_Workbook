package Atcoder.practice_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://atcoder.jp/contests/practice/tasks/practice_1 (A - Welcome to AtCoder)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.25 (O)
 **/
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        br.close();

        StringBuilder result = new StringBuilder();
        result.append(a + b + c).append(' ').append(s);

        System.out.print(result);
    }
}
