package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/15235 (Olympiad Pizza)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.01.29 (O)
 * @reference: https://www.acmicpc.net/source/40652639 (Queue 활용)
 **/
public class Q15235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] persons = new int[N];
        int personCnt = 0;
        int personIdx = 0;
        int[] eatTimes = new int[N];
        StringBuilder result = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        for(int i=0;i<N;i++) {
            int person = Integer.parseInt(st.nextToken());
            persons[i] = person;
            personCnt += person;
        }

        for(int i=0;i<personCnt;i++) {
            if(personIdx == N) personIdx = 0;

            if(persons[personIdx] == 0) --i;
            else {
                --persons[personIdx];
                if(persons[personIdx] == 0)
                    eatTimes[personIdx] = i+1;
            }

            ++personIdx;
        }

        for(int eatTime : eatTimes)
            result.append(eatTime).append(' ');

        System.out.print(result);
    }
}
