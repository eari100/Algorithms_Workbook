package Baekjoon.branchWithManyConditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2480 (주사위 세개)
 * @classfication: 조건 많은 분기
 * @reference: 카운팅 정렬 풀이(https://www.acmicpc.net/source/40123295)
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 23.01.02 (O)
 **/
public class Q2480 {
    static int[] countArr = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens())
            countArr[Integer.parseInt(st.nextToken())]++;

        int result = 0;
        for(int i = 0; i < countArr.length; i++) {
            if(countArr[i] == 2) {
                result = 1000 + i*100;
                break;
            }
            if(countArr[i] == 3) {
                result = 10000 + i*1000;
                break;
            }

            if(countArr[i] == 1 && i > result)
                result = i;
        }

        if(result < 1100)
            result *= 100;

        System.out.print(result);
    }
}
