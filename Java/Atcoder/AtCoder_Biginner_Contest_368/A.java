package Atcoder.AtCoder_Biginner_Contest_368;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://atcoder.jp/contests/abc368/tasks/abc368_a (A - Cut)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.09.07 (O)
 **/
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[] cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        br.close();

        StringBuilder result = new StringBuilder();

        for(int i=n-k;i<n;i++) {
            result.append(cards[i]).append(' ');
        }

        for(int i=0;i<n-k;i++) {
            result.append(cards[i]).append(' ');
        }

        System.out.print(result);
    }
}
