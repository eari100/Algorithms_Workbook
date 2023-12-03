package Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/19532 (수학은 비대면강의입니다)
 * @classification: bruteforce
 * @문제 푼 날짜 (자력으로 풂?): 23.12.04 (O)
 **/
// todo: 크라메르의 법칙을 이용해서 풀어볼 것
public class Q19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        br.close();

        L1: for(int x=-999;x<=999;x++) {
            for(int y=-999;y<=999;y++) {
                if(x1 * x + y1 * y == r1 && x2 * x + y2 * y == r2) {
                    System.out.print(x + " " + y);
                    break L1;
                }
            }
        }
    }
}
