package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @source: https://www.acmicpc.net/problem/1213 (팰린드롬 만들기)
 * @classfication: greedy
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.05.22 (O)
 **/
public class Q1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = new ArrayList<>();
        for(char c : br.readLine().toCharArray())
            list.add(c);
        br.close();

        if(list.size() == 1)
            System.out.print(list.get(0));

        Collections.sort(list);

        StringBuilder prefix = new StringBuilder();
        StringBuilder infix = new StringBuilder();

        for(int i=1;i<list.size();i++) {
            if(list.get(i-1) == list.get(i)) {
                prefix.append(list.get(i));

                if(i==list.size()-2) // 반례: AAA
                    infix.append(list.get(i+1));

                i++;
            } else {
                infix.append(list.get(i-1));
            }
        }

        StringBuilder postfix = new StringBuilder();

        for(int i = prefix.length()-1;i>=0;i--)
            postfix.append(prefix.charAt(i));

        System.out.println(list.size()/2 == prefix.length() ? String.format("%s%s%s", prefix, infix, postfix) : "I'm Sorry Hansoo");
    }
}
