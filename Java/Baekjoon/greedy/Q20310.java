package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/20310 (타노스)
 * @classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?)
 * @reference: https://www.acmicpc.net/source/43353121 (O(N) 풀이)
 * 1. 23.01.16 (O)
 **/
public class Q20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        br.close();

        int zeroCnt = 0, oneCnt = 0;

        for(char c : S.toCharArray()) {
            if(c == '0') ++zeroCnt;
        }

        oneCnt = S.length() - zeroCnt;

        zeroCnt /= 2;
        oneCnt /= 2;

        StringBuilder sb = new StringBuilder(S);
        int oneIdx = 0;

        while(oneCnt > 0) {
            if(sb.charAt(oneIdx) == '1') {
                sb.deleteCharAt(oneIdx);
                --oneCnt;
            } else ++oneIdx;
        }

        int zeroIdx = sb.length() - 1;

        while(zeroCnt > 0) {
            if(sb.charAt(zeroIdx) == '0') {
                sb.deleteCharAt(zeroIdx);
                --zeroCnt;
            }
            --zeroIdx;
        }

        System.out.print(sb);
    }
}
