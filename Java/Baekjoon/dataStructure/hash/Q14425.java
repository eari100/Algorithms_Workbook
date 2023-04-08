package Baekjoon.dataStructure.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14425 (문자열 집합)
 * @classfication: hash
 * @문제 푼 날짜 (자력으로 풂?): 23.04.08 (X)
 **/
public class Q14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();

        for(int i=0;i<N;i++)
            hashSet.add(br.readLine());

        for(int i=0;i<M;i++) {
            String compare = br.readLine();
            if(hashSet.contains(compare)) {
                ++result;
            }
        }

        br.close();

        System.out.print(result);
    }
}
