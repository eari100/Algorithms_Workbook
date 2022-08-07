package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @source: https://www.acmicpc.net/problem/1946 (신입 사원)
 * @classfication: Greedy
 * @reference: https://www.acmicpc.net/source/39455094 (카운팅 정렬을 활용한 더 효율적인 풀이)
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.08.07 (O)
 **/
public class Q1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int successCnt = 1;

            ArrayList<int[]> persons = new ArrayList<>();

            for(int i=0;i<N;i++) {
                int[] ranks = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                persons.add(ranks);
            }

            Collections.sort(persons, (p1, p2) -> p1[0] - p2[0]);

            int interviewHighRank = persons.get(0)[1];

            for(int i=1;i<persons.size();i++) {
                if(persons.get(i)[1] < interviewHighRank) {
                    interviewHighRank = persons.get(i)[1];
                    ++successCnt;
                }
            }

            result.append(successCnt).append('\n');
        }

        br.close();

        System.out.print(result);
    }
}
