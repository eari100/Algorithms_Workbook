package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @source: https://www.acmicpc.net/problem/1235 (학생 번호)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.02.18 (O)
 **/
public class Q1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), str = 0, end = 0;
        HashSet<String> numSet = new HashSet<>();
        HashSet<String> tmpSet;

        for(int i=0;i<n;i++) {
            String num = br.readLine();
            end = num.length();
            numSet.add(num);
        }

        str = end - 1;

        br.close();

        while(true) {
            tmpSet = new HashSet<>();

            for(String num : numSet) {
                String numSplit = num.substring(str, end);
                tmpSet.add(numSplit);
            }

            if(tmpSet.size() == numSet.size())
                break;

            --str;
        }

        System.out.print(end - str);
    }
}
