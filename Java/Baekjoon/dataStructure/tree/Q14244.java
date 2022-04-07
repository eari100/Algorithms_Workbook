package Baekjoon.dataStructure.tree;

import java.io.*;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/14244 (트리 만들기)
 *@classfication: tree, constructive
 **/
public class Q14244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;

        while(y < n) {
            if(m > 0) --m;
            else x = y;

            ++y;
            System.out.println(x+" "+y);
        }
    }
}
