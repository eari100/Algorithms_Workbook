package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q23803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        final String s = "@";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(s);
            }

            if(i < n-1)
                sb.append('\n');
        }

        StringBuilder result = new StringBuilder();

        for(int i=0;i<4;i++) {
            result.append(sb).append('\n');
        }

        StringBuilder sb2 = new StringBuilder();

        for(int i=0;i<5*n;i++) {
            sb2.append(s);
        }

        for(int j = 0; j < n; j++) {
            result.append(sb2).append('\n');
        }

        System.out.println(result);
    }
}
