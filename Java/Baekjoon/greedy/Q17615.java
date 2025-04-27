package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @source: https://www.acmicpc.net/problem/17615 (볼 모으기)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.04.28 (O)
 **/
public class Q17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> sums = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        String data = br.readLine();
        sums.add(1);

        for(int i=1;i<n;i++) {
            if(data.charAt(i-1) == data.charAt(i)) {
                sums.set(sums.size()-1, sums.get(sums.size()-1)+1);
            } else {
                sums.add(1);
            }
        }

        int a = 0, b = 0;

        if(sums.size() <= 2) {
            System.out.println(0);
            return;
        }

        if(sums.size() % 2 == 0) {
            for(int i=1;i<sums.size()-1;i++) {
                if(i % 2 == 0) {
                    a+=sums.get(i);
                } else {
                    b+=sums.get(i);
                }
            }

            System.out.println(Math.min(a, b));
        } else {
            for(int i=0;i<sums.size();i++) {
                if(i % 2 == 0) {
                    a+=sums.get(i);
                } else {
                    b+=sums.get(i);
                }
            }

            System.out.println(Math.min(b, Math.min(a - sums.get(0), a - sums.get(sums.size()-1))));
        }

        br.close();
    }
}
