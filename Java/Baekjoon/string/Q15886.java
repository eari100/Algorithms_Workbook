package Baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/15886 (내 선물을 받아줘 2)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.06 (O)
 **/
public class Q15886 {
    static int giftCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String map = br.readLine();

        for(int i=1;i<map.length();i++) {
            char current = map.charAt(i);
            char prev = map.charAt(i-1);

            if(prev == 'E' && current == 'W')
                ++giftCount;
        }

        System.out.print(giftCount);
    }
}
