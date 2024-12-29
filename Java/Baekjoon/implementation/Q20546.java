package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/20546 (🐜 기적의 매매법 🐜)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.12.30 (O)
 **/
public class Q20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initMoney = Integer.parseInt(br.readLine());
        int money1 = initMoney, money2 = initMoney;
        int stock1 = 0, stock2 = 0;
        int[] days = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < days.length; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        for(int day : days) {
            if(money1 >= day) {
                stock1 = money1 / day;
                money1 -= day * stock1;
                break;
            }
        }

        for(int i=3;i<days.length; i++) {
            if(days[i-3] < days[i-2] && days[i-2] < days[i-1] && days[i-1] < days[i]) {
                money2 += days[i] * stock2;
                stock2 = 0;
            } else if(days[i-3] > days[i-2] && days[i-2] > days[i-1] && days[i-1] > days[i]) {
                int s = money2 / days[i];
                stock2 += money2 / days[i];
                money2 -= days[i] * s;
            }
        }

        money1 += days[13] * stock1;

        money2 += days[13] * stock2;
        stock2 = 0;

        if(money1 > money2) {
            System.out.print("BNP");
        } else if(money1 < money2) {
            System.out.print("TIMING");
        } else {
            System.out.print("SAMESAME");
        }
    }
}
