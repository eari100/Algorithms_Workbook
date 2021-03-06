package Baekjoon.math;

import java.io.*;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/4153
 *@classfication: Math, 피타고라스 정리
 **/
public class Q4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(x == 0 && y == 0 && z == 0) break;

            if((x * x + y * y) == z * z) {
                System.out.println("right");
            }
            else if(x * x == (y * y + z * z)) {
                System.out.println("right");
            }
            else if(y * y == (z * z + x * x)) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
        }
        br.close();
    }
}
