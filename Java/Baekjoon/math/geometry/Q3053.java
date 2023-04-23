package Baekjoon.math.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/3053 (택시 기하학)
 * @classfication: geometry
 * @문제 푼 날짜 (자력으로 풂?): 23.04.23 (X)
 **/
public class Q3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(Math.PI * Math.pow(R, 2)); // 유클리드 기하학의 원 넓이
        System.out.println(2 * Math.pow(R, 2)); // 택시 기하학의 원 넓이
    }
}
