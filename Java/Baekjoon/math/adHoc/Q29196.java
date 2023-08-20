package Baekjoon.math.adHoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/29196 (소수가 아닌 수 2)
 * @classfication: ad hoc, math
 * @문제 푼 날짜 (자력으로 풂?): 23.08.20 (X)
 * @reference: https://solved.ac/arena/4/editorial
 **/
public class Q29196 {
    final static int q = (int) Math.pow(10, 8);

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double k = Double.parseDouble(br.readLine());
        br.close();
        int p = (int) (k * q);

        result.append("YES").append('\n')
                        .append(p).append(' ').append(q);

        System.out.println(result);
    }
}
