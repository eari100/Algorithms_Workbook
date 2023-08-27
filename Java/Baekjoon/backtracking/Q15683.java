package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/15683 (감시)
 * @classfication: backtracking, implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.27 (O, backtracking + implementation 이라 재미있었음)
 **/
public class Q15683 {
    static int minBlindCnt = Integer.MAX_VALUE;
    static int cctvTotalCnt = 0;

    static int[][] office;
    static ArrayList<int[]> cctvLocations = new ArrayList<>();
    final static int[][][] type1 = {
            {{0, 0}, {0, 1}, {0, 0}, {0, 0}},
            {{0, 0}, {0, 0}, {1, 0}, {0, 0}},
            {{0, 0}, {0, 0}, {0, 0}, {0, -1}},
            {{-1, 0}, {0, 0}, {0, 0}, {0, 0}},
    };

    final static int[][][] type2 = {
            {{0, 0}, {0, 1}, {0, 0}, {0, -1}},
            {{-1, 0}, {0, 0}, {1, 0}, {0, 0}},
    };

    final static int[][][] type3 = {
            {{-1, 0}, {0, 1}, {0, 0}, {0, 0}},
            {{0, 0}, {0, 1}, {1, 0}, {0, 0}},
            {{0, 0}, {0, 0}, {1, 0}, {0, -1}},
            {{-1, 0}, {0, 0}, {0, 0}, {0, -1}},
    };

    final static int[][][] type4 = {
            {{-1, 0}, {0, 1}, {0, 0}, {0, -1}},
            {{-1, 0}, {0, 1}, {1, 0}, {0, 0}},
            {{0, 0}, {0, 1}, {1, 0}, {0, -1}},
            {{-1, 0}, {0, 0}, {1, 0}, {0, -1}},
    };

    final static int[][][] type5 = {
            {{-1, 0}, {0, 1}, {1, 0}, {0, -1}},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        int blindCnt = 0;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int object = Integer.parseInt(st.nextToken());
                office[i][j] = object;

                if(object >= 1 && object <= 5) {
                    ++cctvTotalCnt;
                    cctvLocations.add(new int[]{i, j, -1});
                } else if(object == 0) {
                    ++blindCnt;
                }
            }
        }

        br.close();

        dfs(0, blindCnt);
        System.out.print(minBlindCnt);
    }

    private static void dfs(int cctvCnt, int blindCnt) {
        if(cctvTotalCnt == cctvCnt) {
            minBlindCnt = Math.min(minBlindCnt, blindCnt);
            return;
        }

        int[] cctvInfo = cctvLocations.get(cctvCnt);
        int x = cctvInfo[0];
        int y = cctvInfo[1];
        int dirType = cctvInfo[2];
        int cctvType = office[x][y];
        int[][][] typeDir = getTypeDirections(cctvType);

        for(int i=dirType+1;i<typeDir.length;i++) {
            int[][] moves = typeDir[i];
            ArrayList<int[]> blindCoordinate = new ArrayList<>();

            for(int j=0;j<moves.length;j++) {
                int[] move = moves[j];
                int x2 = move[0];
                int y2 = move[1];

                if(x2 == 0 && y2 == 0) continue;

                int x3 = x;
                int y3 = y;

                while(true) {
                    x3 += x2;
                    y3 += y2;

                    if(x3 < 0 || x3 >= office.length || y3 < 0 || y3 >= office[0].length)
                        break;
                    if(office[x3][y3] == 6)
                        break;
                    if(office[x3][y3] == 0) {
                        office[x3][y3] = -1;
                        blindCoordinate.add(new int[]{x3, y3});
                    }
                }
            }

            dfs(cctvCnt+1, blindCnt - blindCoordinate.size());

            for(int[] bc : blindCoordinate) {
                office[bc[0]][bc[1]] = 0;
            }
        }
    }

    private static int[][][] getTypeDirections(int type) {
        if(type == 1) {
            return type1;
        } else if(type == 2) {
            return type2;
        } else if(type == 3) {
            return type3;
        } else if(type == 4) {
            return type4;
        } else if(type == 5) {
            return type5;
        }

        return new int[][][]{};
    }
}
