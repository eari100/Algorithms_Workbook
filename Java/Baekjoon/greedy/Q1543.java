package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/1543 (문서 검색)
 * @classfication: greedy
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.04.17 (X, 반례 못 찾음)
 * @다른 풀이: https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-1543%EB%B2%88-%EB%AC%B8%EC%84%9C%EC%9E%91%EC%97%85-%EC%9E%90%EB%B0%94 (StringBuidler)
 **/
public class Q1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String findWord = br.readLine();
        br.close();
        int matching = 0;
        int copyOfI = 0;

        for(int i=0;i<doc.length();i++) {
            for(int j=0;j<findWord.length();j++) {
                if(j==0) copyOfI = i;
                if(copyOfI == doc.length()) break;
                if(doc.charAt(copyOfI) != findWord.charAt(j)) break;
                ++copyOfI;
                if(j == findWord.length() - 1) {
                    i += findWord.length() -1;
                    ++matching;
                }
            }
        }

        System.out.print(matching);
    }
}
