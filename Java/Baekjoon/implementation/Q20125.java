package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/20125 (쿠키의 신체 측정)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.12.02 (O)
 **/
public class Q20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int row = Integer.parseInt(br.readLine());
        char[][] map = new char[row][row];
        int headX = -1, headY = -1;

        for(int i=0;i<row;i++) {
            String s = br.readLine();
            for(int j=0;j<row;j++) {
                char obj = s.charAt(j);
                if(headX == -1 && headY == -1 && obj == '*') {
                    headX = i;
                    headY = j;
                }

                map[i][j] = obj;
            }
        }

        br.close();

        int heartX = headX+1, heartY = headY;

        int leftArmLen = getSize(map, heartX, heartY, 0, -1);
        int rightArmLen = getSize(map, heartX, heartY, 0, 1);
        int waistLen = getSize(map, heartX, heartY, 1, 0);

        int waistX = heartX + waistLen, waistY = heartY;
        int leftLegLen = getSize(map, waistX, waistY-1, 1, 0);
        int rightLegLen = getSize(map, waistX, waistY+1, 1, 0);

        result.append(heartX+1).append(' ').append(heartY+1).append('\n')
                .append(leftArmLen).append(' ').append(rightArmLen).append(' ').append(waistLen).append(' ').append(leftLegLen).append(' ').append(rightLegLen);

        System.out.print(result);
    }

    private static int getSize(char[][] map, int x, int y, int dX, int dY) {
        int len = 0;
        while(true) {
            x += dX;
            y += dY;

            if(x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] == '_') {
                break;
            }

            ++len;
        }

        return len;
    }
}
