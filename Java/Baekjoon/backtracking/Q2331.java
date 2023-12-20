package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2331 (반복수열)
 * @classfication: backtrancking
 * @문제 푼 날짜 (자력으로 풂?): 23.12.20 (X, 숫자의 자리 별 값을 추출하는 로직을 짜는 것을 못했음)
 **/
public class Q2331 {
    static HashMap<Long, Integer> index = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        br.close();

        index.put(A, index.size());

        System.out.print(dfs(A, P));
    }

    private static int dfs(long A1, int P) {
        long A2 = process(A1, P);

        if(index.containsKey(A2)) {
            return index.get(A2);
        }

        index.put(A2, index.size());

        return dfs(A2, P);
    }
    private static long process(long num, int P) {
        long result = 0;

        while(num > 0) {
            result += Math.pow(num % 10, P);
            num /= 10;
        }

        return result;
    }
}
