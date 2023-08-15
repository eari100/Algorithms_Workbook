package SWEA.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Problem: 13218. 조별과제
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.14 (O)
 **/
public class Q13218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for(int i=1;i<=T;i++) {
            int x = Integer.parseInt(br.readLine());
            result.append('#').append(i).append(' ').append(x / 3).append('\n');
        }

        br.close();

        System.out.print(result);
    }
}
