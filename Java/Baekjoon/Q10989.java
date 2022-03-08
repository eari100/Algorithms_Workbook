package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@source: https://www.acmicpc.net/problem/10989
 *@classfication: counting sort
 **/
public class Q10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        StringBuilder result = new StringBuilder();

        for(int i=0;i<N;i++)
            arr[Integer.parseInt(br.readLine())]++;
        br.close();

        for(int i=1;i<arr.length;i++)
            result.append((i+"\n").repeat(arr[i]));

        System.out.print(result);
    }
}
