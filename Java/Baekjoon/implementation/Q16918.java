package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/16918 (봄버맨)
 *@classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.01.24 (O, 업솔빙 해볼 것(지문 파악, 부등호 반대로 하는 실수로 인해서 오랜 시간 걸림))
 **/
public class Q16918 {
    static final int[] nx = new int[]{-1, 1, 0, 0};
    static final int[] ny = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        int[][] statusMap = new int[R][C];

        for(int i=0;i<R;i++) {
            String row = br.readLine();

            for(int j=0;j<C;j++) {
                char c = row.charAt(j);
                map[i][j] = c;
                if(c == '.')  statusMap[i][j] = -1;
                else if(c == 'O') statusMap[i][j] = 1;
            }
        }

        br.close();

        System.out.print(getAnswer(getMapAfterTime(N, map, statusMap)));
    }

    private static char[][] getMapAfterTime(int time, char[][] map, int[][] statusMap) {
        if(time == 1) return map;

        for(int i=2;i<time+1;i++) {
            boolean[][] visited = new boolean[map.length][map[0].length];
            for(int r=0;r<map.length;r++) {
                for(int c=0;c<map[0].length;c++) {
                    if(visited[r][c]) continue;

                    if(statusMap[r][c] == -1) {
                        if(i % 2 == 0) {
                            ++statusMap[r][c];
                            map[r][c] = 'O';
                        }
                    } else if(statusMap[r][c]+1 < 3) {
                        statusMap[r][c]++;
                    } else if(statusMap[r][c] == 2){
                        statusMap[r][c] = -1;
                        map[r][c] = '.';

                        for(int j=0;j<nx.length;j++) {
                            int dx = r + nx[j];
                            int dy = c + ny[j];

                            if(dx < 0 || dx > map.length -1 || dy < 0 || dy > map[0].length -1) continue;
                            if(statusMap[dx][dy] == 2) continue;

                            statusMap[dx][dy] = -1;
                            map[dx][dy] = '.';
                            visited[dx][dy] = true;
                        }
                    }
                }
            }
        }

        return map;
    }

    private static String getAnswer(char[][] map) {
        StringBuilder answer = new StringBuilder();

        for(char[] arr : map) {
            for(char c : arr) {
                answer.append(c);
            }
            answer.append('\n');
        }

        return answer.toString();
    }
}
