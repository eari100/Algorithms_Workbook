package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/21608 (상어 초등학교)
 * @classification: implementation
 * @문제 푼 날짜 (자력솔?): 23.12.31 (O)
 **/
public class Q21608 {
    static int[][] classRoom;
    static int[][] likePersonsArray;
    static final int[] nX = {-1, 1, 0, 0};
    static final int[] nY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int studentsCnt = (int) Math.pow(n, 2);

        classRoom = new int[n][n];
        for(int[] arr : classRoom) {
            Arrays.fill(arr, -1);
        }

        likePersonsArray = new int[studentsCnt][4];

        for(int i=0;i<studentsCnt;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;

            for(int j=0;j<4;j++) {
                int num2 = Integer.parseInt(st.nextToken()) - 1;

                likePersonsArray[num][j] = num2;
            }

            chooseSeat(num);
        }

        br.close();

        int sumScore = 0;

        for(int x=0;x<classRoom.length;x++) {
            for(int y=0;y<classRoom[0].length;y++) {
                sumScore += calScore(x, y);
            }
        }

        System.out.print(sumScore);
    }

    private static void chooseSeat(int num) {
        int bestLikeScore = -1, bestEmptyScore = -1;
        int[] likePersons = likePersonsArray[num];
        int[] tmpSeat = new int[2];

        for(int x=0;x<classRoom.length;x++) {
           for(int y=0;y<classRoom[0].length;y++) {
               int likeScore = 0, emptyScore = 0;

               if(classRoom[x][y] != -1)
                   continue;

               for(int i=0;i<nX.length;i++) {
                   int x2 = x + nX[i], y2 = y + nY[i];

                   if(x2 < 0 || x2 >= classRoom.length || y2 < 0 || y2 >= classRoom[0].length)
                        continue;

                   if(classRoom[x2][y2] == -1) {
                       ++emptyScore;
                   } else {
                       for(int likePerson : likePersons) {
                           if(classRoom[x2][y2] == likePerson) {
                               ++likeScore;
                               break;
                           }
                       }
                   }
               }

               if(likeScore > bestLikeScore) {
                   tmpSeat[0] = x;
                   tmpSeat[1] = y;

                   bestLikeScore = likeScore;
                   bestEmptyScore = emptyScore;
               } else if(likeScore == bestLikeScore) {
                   if(emptyScore > bestEmptyScore) {
                       tmpSeat[0] = x;
                       tmpSeat[1] = y;

                       bestEmptyScore = emptyScore;
                   }
               }
           }
        }

        classRoom[tmpSeat[0]][tmpSeat[1]] = num;
    }

    private static int calScore(int x, int y) {
        int num = classRoom[x][y], likeCnt = 0;

        for(int i=0;i<nX.length;i++) {
            int x2 = x + nX[i], y2 = y + nY[i];

            if(x2 < 0 || x2 >= classRoom.length || y2 < 0 || y2 >= classRoom[0].length)
                continue;

            for(int likePersons : likePersonsArray[num]) {
                if(likePersons == classRoom[x2][y2]) {
                    ++likeCnt;
                    break;
                }
            }
        }

        return likeCnt == 0 ? 0 : (int) Math.pow(10, likeCnt-1);
    }
}
