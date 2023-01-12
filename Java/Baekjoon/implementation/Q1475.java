package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/1475 (방 번호)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 23.01.12 (O, 더 좋은 아이디어가 있으니 업솔빙하면 좋을 것 같다.)
 **/
public class Q1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numList = br.readLine();
        br.close();

        int numOfSet = 1;
        int[] set = new int[9];
        Arrays.fill(set, 1);
        ++set[6];

        for(char numChar : numList.toCharArray()) {
            int num = Character.getNumericValue(numChar);

            if(num == 9) num = 6;

            if(set[num] == 0) {
                set = addSet(set);
                ++numOfSet;
            }

            --set[num];
        }

        System.out.print(numOfSet);
    }

    private static int[] addSet(int[] set) {
        for(int i=0;i<set.length;i++)
            ++set[i];

        ++set[6];

        return set;
    }
}
