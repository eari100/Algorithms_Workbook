package Baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/27495 (만다라트 만들기)
 * @classfication: sort
 * @문제 푼 날짜 (자력으로 풂?): 24.12.10 (X, String 은 unicode 오름차순으로 정렬된다)
 **/
public class Q27495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] board = new String[9][9];
        StringBuilder result = new StringBuilder();
        PriorityQueue<Plan> pq = new PriorityQueue<>();
        final int[][] child = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for(int i=0;i<9;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<9;j++) {
                String plan = st.nextToken();
                board[i][j] = plan;

                if( (i == 1 || i == 4 || i == 7) && (j == 1 || j == 4 || j == 7)) {
                    if(i == 4 && j == 4) continue;

                    pq.offer(new Plan(plan, new int[]{i, j}));
                }
            }
        }

        br.close();

        PriorityQueue<Plan> pq2;

        for(int i=1;i<9;i++) {
            Plan plan = pq.poll();
            result.append('#').append(i).append(". ").append(plan.name).append('\n');
            int[] loc = plan.loc;

            pq2 = new PriorityQueue<>();

            for(int[] move : child) {
                int x = loc[0] + move[0];
                int y = loc[1] + move[1];

                pq2.offer(new Plan(board[x][y], new int[]{}));
            }

            for(int j=1;j<9;j++) {
                Plan cplan = pq2.poll();
                result.append('#').append(i).append('-').append(j).append(". ").append(cplan.name).append('\n');
            }
        }

        System.out.print(result);
    }

    static class Plan implements Comparable<Plan> {
        String name;
        int[] loc;

        public Plan(String name, int[] loc) {
            this.name = name;
            this.loc = loc;
        }

        // lexicographical order
        @Override
        public int compareTo(Plan other) {
//            int minLength = Math.min(this.name.length(), other.name.length());
//
//            for (int i = 0; i < minLength; i++) {
//                char c1 = this.name.charAt(i);
//                char c2 = other.name.charAt(i);
//
//                if (Character.isDigit(c1) && !Character.isDigit(c2)) {
//                    return -1;
//                } else if (!Character.isDigit(c1) && Character.isDigit(c2)) {
//                    return 1;
//                }
//
//                if (Character.isUpperCase(c1) && !Character.isUpperCase(c2)) {
//                    return -1;
//                } else if (!Character.isUpperCase(c1) && Character.isUpperCase(c2)) {
//                    return 1;
//                }
//
//                if (c1 != c2) {
//                    return Character.compare(c1, c2);
//                }
//            }
//
//            return Integer.compare(this.name.length(), other.name.length());

            return this.name.compareTo(other.name);
        }
    }
}
