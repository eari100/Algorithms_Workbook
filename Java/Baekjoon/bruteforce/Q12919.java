package Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/12919 (A와 B 2)
 * @classification: brute-force
 * @문제 푼 날짜 (자력솔?): 23.12.24 (O)
 **/
public class Q12919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(), r = br.readLine();
        br.close();

        System.out.print(process(r, s) ? 1 : 0);
    }

    private static boolean process(String r, String s) {
        if(r.length() < s.length())
            return false;

        if(r.length() == s.length()) {
            return r.equals(s);
        }

        char first = r.charAt(0), last = r.charAt(r.length()-1);
        boolean proc1 = false, proc2 = false;

        if(last == 'A') {
            proc1 = process(convert1(r), s);
        }
        if(first == 'B') {
            proc2 = process(convert2(r), s);
        }

        return proc1 || proc2;
    }

    private static String convert1(String r) {
        return r.substring(0, r.length()-1);
    }

    private static String convert2(String r) {
        StringBuilder converted = new StringBuilder(r);
        converted.deleteCharAt(0).reverse();

        return converted.toString();
    }
}
