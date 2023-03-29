package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/17144 (미세먼지 안녕!)
 * @classfication: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.03.29 (O)
 **/
public class Q17144 {
    static int[][] house;
    static int[][] houseTmp;
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int cleaner[] = new int[2];
        int cleanerIdx = 0;

        house = new int[R][C];

        for(int i=0;i<R;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++) {
                int num = Integer.parseInt(st.nextToken());

                if(num == -1) cleaner[cleanerIdx++] = i;

                house[i][j] = num;
            }
        }

        br.close();

        for(int i=0;i<T;i++) {
            houseTmp = new int[R][C];
            for(int j=0;j<house.length;j++) {
                for(int k=0;k<house[0].length;k++) {
                    houseTmp에_확산된_먼지를_저장하다(j, k);
                }
            }
            houseTmp와_house를_병합하다(house, houseTmp);
            공기청정기가_작동하다(cleaner[0], true);
            공기청정기가_작동하다(cleaner[1], false);
        }

        System.out.print(미세먼지_갯수_구하기(house));
    }

    private static void houseTmp에_확산된_먼지를_저장하다(int x1, int y1) {
        if(house[x1][y1] <= 0) return;

        int dust = house[x1][y1];
        int moveDust = dust / 5;

        for(int i=0;i<nx.length;i++) {
            int x2 = x1 + nx[i];
            int y2 = y1 + ny[i];

            if(x2 < 0 || x2 > house.length-1 || y2 < 0 || y2 > house[0].length-1) continue;
            if(house[x2][y2] == -1) continue;

            houseTmp[x1][y1] -= moveDust;
            houseTmp[x2][y2] += moveDust;
        }
    }

    private static void houseTmp와_house를_병합하다(int[][] house, int[][] houseTmp) {
        for(int i=0;i<house.length;i++) {
            for(int j=0;j<house[0].length;j++) {
                house[i][j] += houseTmp[i][j];
            }
        }
    }

    private static void 공기청정기가_작동하다(int x, boolean isUp) {
       if(isUp) {
           for(int i=x-1;i>0;i--) {
               house[i][0] = house[i-1][0];
           }

           for(int i=0;i<house[0].length-1;i++) {
               house[0][i] = house[0][i+1];
           }

           for(int i=0;i<x;i++) {
               house[i][house[0].length - 1] = house[i+1][house[0].length - 1];
           }

           for(int i=house[0].length-1;i>1;i--) {
               house[x][i] = house[x][i-1];
           }
       } else {
           for(int i=x+1;i<house.length-1;i++) {
               house[i][0] = house[i+1][0];
           }

           for(int i=1;i<house[0].length;i++) {
               house[house.length-1][i-1] = house[house.length-1][i];
           }

           for(int i=house.length-1;i>x;i--) {
               house[i][house[0].length - 1] = house[i-1][house[0].length - 1];
           }

           for(int i=house[0].length-1;i>1;i--) {
               house[x][i] = house[x][i-1];
           }
       }

        house[x][1] = 0;
    }

    private static int 미세먼지_갯수_구하기(int[][] house) {
        int dust = 0;

        for(int[] arr : house) {
            for(int i : arr) {
                dust += i;
            }
        }

        return dust+2;
    }
}
