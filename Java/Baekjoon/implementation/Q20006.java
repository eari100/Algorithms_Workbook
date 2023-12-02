package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/20006 (랭킹전 대기열)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.12.02 (O)
 **/
// todo: 우선순위 큐를 사용해볼 것 (https://www.acmicpc.net/source/64877591)
public class Q20006 {
    public static void main(String[] args) throws IOException {
        final String STARTED = "Started!";
        final String WAITING = "Waiting!";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<ArrayList<Object[]>> matchings = new ArrayList<>();
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<p;i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            match(matchings, l, n, m);
        }
        br.close();

        StringBuilder result = new StringBuilder();

        for(ArrayList<Object[]> matching : matchings) {
            if(matching.size() == m) {
                result.append(STARTED).append('\n');
            } else {
                result.append(WAITING).append('\n');
            }

            matching.sort(Comparator.comparing(obj -> (String) obj[1]));

            matching.stream().forEach(m1 -> {
                result.append(m1[0]).append(' ').append(m1[1]).append('\n');
            });
        }

        System.out.print(result);
    }

    private static void match(ArrayList<ArrayList<Object[]>> matchings, int l, String n, int m) {
        for(ArrayList<Object[]> matching : matchings) {
            if(matching.size() == m)
                continue;

            int level = (int) matching.get(0)[0];

            int abs = Math.abs(level - l);

            if(abs <= 10) {
                matching.add(new Object[]{l, n});
                return;
            }
        }

        matchings.add(new ArrayList<>());
        matchings.get(matchings.size()-1).add(new Object[]{l, n});
    }
}
