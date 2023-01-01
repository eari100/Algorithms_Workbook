package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/19639 (배틀로얄)
 * @classfication: greedy, 조건 많은 분기
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 23.01.01 (X)
 **/
public class Q19639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int HP =M;

        StringBuilder result = new StringBuilder();

        int[] enemies = new int[X];
        int[] potions = new int[Y];
        int enemiesIdx = 0, potionsIdx = 0;

        for(int i=0;i<X;i++)
            enemies[i] = Integer.parseInt(br.readLine());

        for(int i=0;i<Y;i++)
            potions[i] = Integer.parseInt(br.readLine());

        br.close();

        while(enemiesIdx < X) {
            if(HP > enemies[enemiesIdx]) {
                HP -= enemies[enemiesIdx];
                result.append(-(enemiesIdx+1)).append('\n');
                ++enemiesIdx;
            } else {
                if(potionsIdx < Y) {
                    HP += potions[potionsIdx];
                    result.append(potionsIdx+1).append('\n');
                    ++potionsIdx;
                } else {
                    result = new StringBuilder("0");
                    break;
                }
            }
        }

        while(potionsIdx < Y) {
            result.append(potionsIdx+1).append('\n');
            ++potionsIdx;
        }

        System.out.print(result);
    }
}
