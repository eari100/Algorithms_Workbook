package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1244 (스위치 켜고 끄기)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.12.03 (O, 딴짓하면서 풀어서 잔실수가 많았음. 쉽지만 다시 풀어보자)
 **/
public class Q1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int bulbCnt = Integer.parseInt(br.readLine());
        int[] bulbs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int peopleCnt = Integer.parseInt(br.readLine());

        for(int i=0;i<peopleCnt;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int bulbNum = Integer.parseInt(st.nextToken());

            if(sex == 1) {
                manWork(bulbs, bulbNum);
            } else {
                womanWork(bulbs, bulbNum);
            }
        }

        br.close();

        for(int i=1;i<=bulbs.length;i++) {
            result.append(bulbs[i-1]).append(' ');

            if(i % 20 == 0) {
                result.append('\n');
            }
        }

        System.out.print(result);
    }

    private static void manWork(int[] bulbs, int bulbNum) {
        int nextBulbNum = bulbNum;
        while(nextBulbNum <= bulbs.length) {
            changeBulb(bulbs, nextBulbNum);
            nextBulbNum += bulbNum;
        }
    }

    private static void womanWork(int[] bulbs, int bulbNum) {
        int plus = 1;
        changeBulb(bulbs, bulbNum);

        while(bulbNum - plus >= 1 && bulbNum + plus <= bulbs.length) {
            if(bulbs[bulbNum - plus - 1] == bulbs[bulbNum + plus - 1]) {
                changeBulb(bulbs, bulbNum - plus);
                changeBulb(bulbs, bulbNum + plus);
            } else {
                break;
            }

            ++plus;
        }
    }

    private static void changeBulb(int[] bulbs, int bulbNum) {
        if(bulbs[bulbNum-1] == 0) {
            bulbs[bulbNum-1] = 1;
        } else {
            bulbs[bulbNum-1] = 0;
        }
    }
}
