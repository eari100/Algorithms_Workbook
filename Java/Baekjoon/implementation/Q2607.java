package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/2607 (비슷한 단어)
 * @classification: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.06.29 (O)
 **/
public class Q2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        int match = 0;
        int len = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if (i == 0) {
                for (char c : str.toCharArray()) {
                    len = str.length();
                    ++alphabet[c - 'A'];
                }
            } else {
                int[] copyAlphabet = Arrays.copyOf(alphabet, alphabet.length);
                int len2 = str.length();

                if (len2 >= len - 1 && len2 <= len + 1) {
                    int count = Math.min(len, len2);

                    if(len == len2) {
                        --count;
                    }

                    for (char c : str.toCharArray()) {
                        if (copyAlphabet[c - 'A'] > 0) {
                            --count;
                            --copyAlphabet[c - 'A'];
                        }
                    }

                    if (count <= 0) {
                        ++match;
                    }
                }
            }
        }

        br.close();

        System.out.print(match);
    }
}
