package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2785 (체인)
 * @classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?): 23.03.04 (X, 지문 이해를 못함)
 * @reference: Priority Queue 활용 가능한 풀이도 존재
 **/
public class Q2785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> chains = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        for(int i=0;i<N;i++)
            chains.add(Integer.valueOf(st.nextToken()));

        br.close();

        Collections.sort(chains);

        while(chains.size() > 1) {
            if(chains.get(0) > 0) {
                chains.set(0, chains.get(0) - 1);
                chains.remove(chains.size()-1);
                ++result;
            } else {
                chains.remove(0);
            }
        }

        System.out.print(result);
    }
}
