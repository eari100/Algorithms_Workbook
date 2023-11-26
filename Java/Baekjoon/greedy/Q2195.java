package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2195 (문자열 복사)
 * @classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?): 23.11.26 (O)
 **/
public class Q2195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();
        br.close();

        int callCopyCnt = 0;
        int maxSplitLen = 0;

        for(int pIdx=0;pIdx<P.length();pIdx++) {

            int splitLen = 0;
            int pPlusIdx = 0;

            for(int sIdx=0;sIdx<S.length();sIdx++) {
                if(P.charAt(pIdx+pPlusIdx) != S.charAt(sIdx)) {
                    maxSplitLen = Math.max(maxSplitLen, splitLen);
                    splitLen = 0;
                    pPlusIdx = 0;

                    continue;
                }

                ++splitLen;
                ++pPlusIdx;

                if(pIdx + pPlusIdx >= P.length())
                    break;
            }
            maxSplitLen = Math.max(maxSplitLen, splitLen);

            pIdx += maxSplitLen - 1;
            maxSplitLen = 0;
            ++callCopyCnt;
        }

        System.out.print(callCopyCnt);
    }
}
