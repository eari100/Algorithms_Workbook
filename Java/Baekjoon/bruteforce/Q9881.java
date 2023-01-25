package Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/9881 (Ski Course Design)
 * @classfication: bruteforce
 * @문제 푼 날짜 (자력으로 풂?): 23.01.25 (X, 강추 업솔빙 해볼 것)
 * @reference: https://travelbeeee.tistory.com/491
 **/
public class Q9881 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] mountains = new int[N];
        int result = Integer.MAX_VALUE;

        for(int i=0;i<N;i++)
            mountains[i] = Integer.parseInt(br.readLine());

        br.close();

        for(int min=0;min<=100-17;min++) {
            int max = min+17;
            int tmp = 0;
            for(int mountain : mountains) {
                if(mountain < min) tmp += Math.pow(mountain - min, 2);
                if(mountain > max) tmp += Math.pow(max - mountain, 2);
            }
            result = Math.min(result, tmp);
        }

        System.out.print(result);
    }
}
