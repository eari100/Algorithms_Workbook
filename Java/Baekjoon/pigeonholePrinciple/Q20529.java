package Baekjoon.pigeonholePrinciple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/20529 (가장 가까운 세 사람의 심리적 거리)
 * @classification: 비둘기집 원리
 * @문제 푼 날짜 (자력으로 풂?): 23.12.15 (X)
 **/
public class Q20529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for(int i=0;i<t;i++) {
            int personCnt = Integer.parseInt(br.readLine());

            String[] persons = new String[personCnt];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<personCnt;j++) {
                persons[j] = st.nextToken();
            }

            if(personCnt >= 33) {
                result.append(0).append('\n');
                continue;
            }

            int minDiff = Integer.MAX_VALUE;

            for(int a=0;a<personCnt-2;a++) {
                for(int b=a+1;b<personCnt-1;b++) {
                    int diff1 = diff(persons[a], persons[b]);
                    for(int c=b+1;c<personCnt;c++) {
                        int diff2 = diff(persons[b], persons[c]);
                        int diff3 = diff(persons[a], persons[c]);
                        int diffSum = diff1 + diff2 + diff3;

                        minDiff = Math.min(minDiff, diffSum);
                    }
                }
            }

            result.append(minDiff).append('\n');
        }

        br.close();

        System.out.print(result);
    }

    private static int diff(String p1, String p2) {
        int diff = 0;

        for(int i=0;i<p1.length();i++) {
            if(p1.charAt(i) != p2.charAt(i))
                ++diff;
        }

        return diff;
    }
}
