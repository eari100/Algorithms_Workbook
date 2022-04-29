package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/5766 (할아버지는 유명해!)
 *@classfication: implementation, counting sort
 *@reference: https://hyeyun.tistory.com/entry/%EB%B0%B1%EC%A4%80-BOJ-5766-%ED%95%A0%EC%95%84%EB%B2%84%EC%A7%80%EB%8A%94-%EC%9C%A0%EB%AA%85%ED%95%B4
 **/
public class Q5766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int[][] arr = new int[10000+1][2];

            for(int i=1;i<=10000;i++) {
                arr[i][0] = i;
            }

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st1.nextToken());
            int M = Integer.parseInt(st1.nextToken());

            if(N==0 && M==0) break;

            for(int i=0;i<N;i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++) {
                    arr[Integer.parseInt(st2.nextToken())][1] += 1;
                }
            }

            Arrays.sort(arr, (a1, a2) -> {
               int result = a2[1] - a1[1];

               if(result == 0) result = a1[0] - a2[0];

               return result;
            });

            for(int i=1;i<=10000;i++) {
                if(arr[i-1][1] != arr[i][1]) {
                    System.out.print(arr[i][0] +" ");
                    i++;

                    while(i<=10000) {
                        if(arr[i-1][1] != arr[i][1]) break;

                        System.out.print(arr[i][0] +" ");
                        i++;
                    }
                    break;
                }
            }
            System.out.println();
        }
        br.close();
    }
}
