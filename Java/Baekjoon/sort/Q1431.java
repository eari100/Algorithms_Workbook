package Baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/1431 (시리얼 번호)
 * @classfication: sort
 * @문제 푼 날짜 (자력으로 풂?): 23.07.12 (X)
 **/
public class Q1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for(int i=0; i<words.length; i++)
            words[i] = br.readLine();

        br.close();

        Arrays.sort(words, (word1, word2) -> {
            if(word1.length() != word2.length())
                return word1.length() - word2.length();

            int word1NumSum = 0, word2NumSum = 0;

            for(int i=0; i<word1.length(); i++) {
                char w1 = word1.charAt(i);
                if(Character.isDigit(w1))
                    word1NumSum += w1 - '0';

                char w2 = word2.charAt(i);
                if(Character.isDigit(w2))
                    word2NumSum += w2 - '0';
            }

            if(word1NumSum != word2NumSum)
                return word1NumSum - word2NumSum;

            return word1.compareTo(word2);
        });

        StringBuilder result = new StringBuilder();
        for(String word : words)
            result.append(word).append('\n');

        System.out.print(result);
    }
}
