package SWEA.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Problem: 16368. 24시간
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.14 (O)
 **/
public class Q16368 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=1;i<=T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int sum = A+B;
            result.append('#').append(i).append(' ').append(sum % 24).append('\n');
        }

        br.close();

        System.out.print(result);
    }
}
