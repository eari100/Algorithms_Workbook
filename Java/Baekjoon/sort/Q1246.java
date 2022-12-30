package Baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *@source: https://www.acmicpc.net/problem/1246
 *@classfication: sort
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.12.31 (O)
 **/
public class Q1246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> eggPrices = new ArrayList<>();
        int maxPrice = 0;
        int maxSumPrice = 0;
        StringBuilder result = new StringBuilder();

        for(int i=0;i<M;i++)
            eggPrices.add(Integer.parseInt(br.readLine()));

        br.close();

        Collections.sort(eggPrices, Collections.reverseOrder());

        for(int i=0;i<Math.min(N, M);i++) {
            int nPrice = eggPrices.get(i) * (i+1);
            if(nPrice > maxSumPrice) {
                maxSumPrice = nPrice;
                maxPrice = eggPrices.get(i);
            }
        }

        result.append(maxPrice).append(" ").append(maxSumPrice);

        System.out.println(result);
    }
}
