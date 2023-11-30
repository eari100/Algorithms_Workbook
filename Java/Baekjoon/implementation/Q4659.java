package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/4659 (비밀번호 발음하기)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.12.01 (O)
 **/
public class Q4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        StringBuilder result = new StringBuilder();

        while(true) {
            String word = br.readLine();

            if(word.equals("end"))
                break;

            boolean includesVowels = false;
            int vowelsCnt = 0, consonantCnt = 0;

            for(int i=0;i<word.length();i++) {
                char c = word.charAt(i);

                if(i > 0) {
                    char prev = word.charAt(i-1);

                    if(c != 'e' && c != 'o') {
                        if(c == prev) {
                            result.append('<').append(word).append('>').append(" is not acceptable.").append('\n');
                            break;
                        }
                    }
                }

                for(int j=0;j<vowels.length;j++) {
                    char vowel = vowels[j];
                    if(c == vowel) {
                        includesVowels = true;

                        ++vowelsCnt;
                        consonantCnt = 0;
                        break;
                    }

                    if(j == vowels.length-1) {
                        ++consonantCnt;
                        vowelsCnt = 0;
                    }
                }

                if(vowelsCnt == 3 || consonantCnt == 3) {
                    result.append('<').append(word).append('>').append(" is not acceptable.").append('\n');
                    break;
                }

                if(i == word.length() - 1) {
                    if(!includesVowels) {
                        result.append('<').append(word).append('>').append(" is not acceptable.").append('\n');
                    } else {
                        result.append('<').append(word).append('>').append(" is acceptable.").append('\n');
                    }
                }
            }
        }

        br.close();

        System.out.print(result);
    }
}
