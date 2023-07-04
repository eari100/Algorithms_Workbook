package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1063 (킹)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.07.04 (O)
 **/
public class Q1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        String king = st.nextToken();
        int kingRow = changeRowInt(Character.getNumericValue(king.charAt(1)));
        int kingCol = changeColInt(king.charAt(0));

        String stone = st.nextToken();
        int stoneRow = changeRowInt(Character.getNumericValue(stone.charAt(1)));
        int stoneCol = changeColInt(stone.charAt(0));

        int moveCount = Integer.parseInt(st.nextToken());

        while(moveCount-- > 0 ) {
            String dir = br.readLine();
            int[] movArr = moveDir(dir);

            int kingRow2 = kingRow + movArr[0];
            int kingCol2 = kingCol + movArr[1];

            if(kingRow2 < 0 || kingRow2 > 7 || kingCol2 < 0 || kingCol2 > 7) continue;

            if(kingRow2 == stoneRow && kingCol2 == stoneCol) {
                int stoneRow2 = stoneRow + movArr[0];
                int stoneCol2 = stoneCol + movArr[1];

                if(stoneRow2 < 0 || stoneRow2 > 7 || stoneCol2 < 0 || stoneCol2 > 7) continue;

                stoneRow = stoneRow2;
                stoneCol = stoneCol2;
            }

            kingRow = kingRow2;
            kingCol = kingCol2;
        }

        br.close();

        result.append(changeColChar(kingCol)).append(changeRowChar(kingRow)).append('\n')
                .append(changeColChar(stoneCol)).append(changeRowChar(stoneRow));

        System.out.print(result);
    }


    private static int changeRowInt(int r) {
        return 8 - r;
    }

    private static int changeColInt(char c) {
        return c - 'A';
    }


    private static int changeRowChar(int r) {
        return 8 - r;
    }

    private static char changeColChar(int c) {
        return (char)((int)'A' + c);
    }

    private static int[] moveDir(String dir) {
        if(dir.equals("R"))
            return new int[]{0, 1};
        else if(dir.equals("L"))
            return new int[]{0, -1};
        else if(dir.equals("B"))
            return new int[]{1, 0};
        else if(dir.equals("T"))
            return new int[]{-1, 0};
        else if(dir.equals("RT"))
            return new int[]{-1, 1};
        else if(dir.equals("LT"))
            return new int[]{-1, -1};
        else if(dir.equals("RB"))
            return new int[]{1, 1};
        else if(dir.equals("LB"))
            return new int[]{1, -1};

        return new int[]{};
    }
}
