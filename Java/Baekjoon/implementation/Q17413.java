package Baekjoon.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *@source: https://programmers.co.kr/learn/courses/30/lessons/17413 (단어 뒤집기 2)
 *@classfication: implementation, string
 **/
public class Q17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        br.close();

        List<StringBuilder> list = new ArrayList<>();

        StringBuilder tag = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for(int i=0;i<S.length();i++) {
            if(S.charAt(i) == '<') {
                if(word.length() > 0) {
                    list.add(word);
                    word = new StringBuilder();
                }

                while(true) {
                    tag.append(S.charAt(i));
                    if(S.charAt(i) == '>') {
                        list.add(tag);
                        tag = new StringBuilder();
                        break;
                    }
                    i++;
                }
            } else if(S.charAt(i)==' ') {
                if(word.length()>0) {
                    list.add(word.insert(0, ' '));
                    word = new StringBuilder();
                }
            } else{
                word.append(S.charAt(i));
            }
        }

        if(word.length()>0) {
            list.add(word);
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder sb : list) {
            if(!sb.toString().contains("<")) {
                sb = sb.reverse();
            }
            result.append(sb);
        }

        System.out.print(result);
    }
}
