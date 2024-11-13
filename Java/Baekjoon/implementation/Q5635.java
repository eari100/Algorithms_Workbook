package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/5635 (생일)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.11.13 (O)
 **/
public class Q5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Human[] humans = new Human[n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            humans[i] = new Human(name, y, m, d);
        }

        br.close();

        Arrays.sort(humans, (h1, h2) -> {
            if(h1.year != h2.year) {
                return h2.year - h1.year;
            }

            if(h1.month != h2.month) {
                return h2.month - h1.month;
            }

            return h2.day - h1.day;
        });

        StringBuilder result = new StringBuilder();
        result.append(humans[0].name).append('\n');
        result.append(humans[n-1].name).append('\n');

        System.out.print(result);
    }

    public static class Human {
        String name;
        int year;
        int month;
        int day;

        public Human(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
}
