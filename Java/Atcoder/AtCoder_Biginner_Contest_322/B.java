package Atcoder.AtCoder_Biginner_Contest_322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://atcoder.jp/contests/abc322/tasks/abc322_b (B - Prefix and Suffix)
 * @classfication: string
 * @문제 푼 날짜 (자력으로 풂?): 23.09.30 (O, chatgpt 도움)
 **/
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String S = br.readLine();
        String T = br.readLine();

        br.close();

        boolean isPrefix = T.startsWith(S);
        boolean isSuffix = T.endsWith(S);

        int answer = 0;
        if (isPrefix && isSuffix) {
            answer = 0;
        } else if (isPrefix) {
            answer = 1;
        } else if (isSuffix) {
            answer = 2;
        } else {
            answer = 3;
        }

        System.out.print(answer);
    }
}
