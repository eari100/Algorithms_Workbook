package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14503 (로봇 청소기)
 * @classfication: implementation
 * @reference: https://nanyoungkim.tistory.com/83
 **/
public class Q14503 {

    static int[][] arr;
    static int x;
    static int y;
    static int[] dX = new int[]{0, 1, 0, -1}; // 서,남,동,북
    static int[] dY = new int[]{-1, 0, 1, 0};
    static int[] bX = new int[]{0, -1, 0, 1};
    static int[] bY = new int[]{1, 0, -1, 0};
    static int d;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrX = Integer.parseInt(st.nextToken());
        int arrY = Integer.parseInt(st.nextToken());
        arr = new int[arrX][arrY];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = 3 - Integer.parseInt(st.nextToken()); // dArr 인덱스 구하기 ({3, 2, 1, 0} 서->남->동->북)

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr[x][y] = -1;
        clean();

        System.out.println(answer);
    }

    private static void clean() {
        int nX, nY = 0;

        while(true) {
            for(int i=1;i<=4;i++) {
                ++d;
                if(d==4) d = 0;

                nX = x + dX[d];
                nY = y + dY[d];

                if(nX < 0 || nX > arr.length -1 || nY < 0 || nY > arr[0].length -1) continue;

                if(arr[nX][nY] == 0) {
                    x = nX;
                    y = nY;

                    arr[x][y] = -1; // 청소
                    ++answer;
                    break;
                }

                if(i==4) {
                    nX = x + bX[d];
                    nY = y + bY[d];

                    if(nX < 0 || nX > arr.length -1 || nY < 0 || nY > arr[0].length -1) continue;

                    if(arr[nX][nY] == 1) return;

                    x = nX;
                    y = nY;
                }
            }
        }
    }
}
