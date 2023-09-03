package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2251 (물통)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.09.03 (O, 독해 능력을 향상 시킬 것 / Collection 은 매개변수로 주입할 경우 얕은 복사가 된다)
 **/
public class Q2251 {
    static HashSet<ArrayList<Integer>> set = new HashSet<>();
    static int[] cupSizes = new int[3];
    static HashSet<Integer> cCups = new HashSet<>();

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        ArrayList<Integer> abc = new ArrayList<>();

        for(int i=0;i<3;i++) {
            int waterSize = Integer.parseInt(st.nextToken());
            cupSizes[i] = waterSize;

            abc.add(i == 2 ? waterSize : 0);
        }

        set.add(abc);

        search(abc);

        PriorityQueue<Integer> sortedCups = new PriorityQueue<>();

        for(int cup : cCups)
            sortedCups.offer(cup);

        StringBuilder result = new StringBuilder();

        while( !sortedCups.isEmpty() ) {
            result.append(sortedCups.poll()).append(' ');
        }

        System.out.print(result);
    }

    private static void search(ArrayList<Integer> cups) {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(i == j) continue;

                int behindSetSize = set.size();
                ArrayList<Integer> afterCups = moveWater(cups, i, j);
                int afterSetSize = set.size();

                if(behindSetSize == afterSetSize)
                    continue;

                search(afterCups);
            }
        }
    }

    private static ArrayList<Integer> moveWater(ArrayList<Integer> cups, int from, int to) {
        ArrayList<Integer> newCups = new ArrayList<>(cups);
        int fromCup = newCups.get(from);
        int toCup = newCups.get(to);
        int toCupSize = cupSizes[to];

        if(fromCup == 0)
            return newCups;

        if(toCup == toCupSize)
            return newCups;

        int diff = fromCup - (toCupSize - toCup);

        if(diff >= 0) {
            newCups.set(from, diff);
            newCups.set(to, toCupSize);
        } else {
            newCups.set(to, toCup + fromCup);
            newCups.set(from, 0);
        }

        set.add(newCups);

        if(newCups.get(0) == 0)
            cCups.add(newCups.get(2));

        return newCups;
    }
}
