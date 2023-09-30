package Atcoder.AtCoder_Biginner_Contest_322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://atcoder.jp/contests/abc322/tasks/abc322_a (A - First ABC 2)
 * @classfication: regular expression, string
 * @문제 푼 날짜 (자력으로 풂?): 23.09.30 (O, 정규식 chatgpt 도움)
 **/
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();
        br.close();

        System.out.println(str.matches(".*ABC.*") ? str.indexOf("ABC") + 1 : -1);
    }
}
