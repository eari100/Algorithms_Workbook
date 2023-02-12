package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/18428 (감시 피하기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.02.12 (O)
 **/
public class Q18428 {
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};
    static String result = "YES";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] 복도 = new char[N][N];
        int 장애물_수 = 3;

        for(int i=0;i<N;i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                복도[i][j] = row.nextToken().charAt(0);
        }

        br.close();

        L1: for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(복도[i][j] == 'T') {
                    for(int k=0;k<nx.length;k++) {
                        int tmpX = i;
                        int tmpY = j;

                        while(true) {
                            tmpX += nx[k];
                            tmpY += ny[k];

                            if(tmpX < 0 || tmpX > N-1 || tmpY < 0 || tmpY > N-1) break;
                            else if(복도[tmpX][tmpY] == 'S') {
                                if(장애물_수 == 0) {
                                    result = "NO";
                                    break L1;
                                } else {
                                    if(k == 0) {
                                        if( !process(복도[tmpX+1][tmpY]) ) break L1;
                                        복도[tmpX+1][tmpY] = 'O';
                                    } else if(k == 1) {
                                        if( !process(복도[tmpX-1][tmpY]) ) break L1;
                                        복도[tmpX-1][tmpY] = 'O';
                                    } else if(k == 2) {
                                        if( !process(복도[tmpX][tmpY+1]) ) break L1;
                                        복도[tmpX][tmpY+1] = 'O';
                                    } else if(k == 3) {
                                        if( !process(복도[tmpX][tmpY-1]) ) break L1;
                                        복도[tmpX][tmpY-1] = 'O';
                                    }
                                    --장애물_수;
                                    break;
                                }
                            } else if(복도[tmpX][tmpY] == 'O') break;
                        }
                    }
                }
            }
        }

        System.out.print(result);
    }

    private static boolean process(char 대상의_옆) {
        if(대상의_옆 == 'T') {
            result = "NO";
            return false;
        } else if(대상의_옆 == 'S' || 대상의_옆 == 'O')
            throw new IllegalArgumentException("결과 값:" + 대상의_옆);

        return true;
    }
}
