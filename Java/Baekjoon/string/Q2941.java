package Baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@source: https://www.acmicpc.net/problem/2941 (크로아티아 알파벳)
 *@classfication: string, implementation
 **/
public class Q2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        String[] croatiaArr = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int croatiaCnt = 0;

        for(String c : croatiaArr) {
            while( str.contains(c) ) {
                str = str.replace(c, "X");
            }
        }

        croatiaCnt += str.length();

        System.out.print(croatiaCnt);
    }
}
