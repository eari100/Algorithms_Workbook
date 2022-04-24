package Baekjoon.implementation;

import java.io.*;
import java.util.*;

/**
 *@source: https://www.acmicpc.net/problem/1251 (단어 나누기)
 *@classfication: implementation
 **/
public class Q1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        List<String> outputList = new ArrayList<>();

        for(int i=0;i<input.length()-2;i++) {
            for(int j=i+1;j<input.length()-1;j++) {
                StringBuilder one = new StringBuilder(input.substring(0, i+1));
                StringBuilder two = new StringBuilder(input.substring(i+1, j+1));
                StringBuilder three = new StringBuilder(input.substring(j+1));

                StringBuilder result = new StringBuilder();
                result.append(one.reverse()).append(two.reverse()).append(three.reverse());

                outputList.add(result.toString());
            }
        }

        Collections.sort(outputList);
        System.out.print(outputList.get(0));
    }
}
