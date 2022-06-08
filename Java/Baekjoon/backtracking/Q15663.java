package Baekjoon.backtracking;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @source: https://www.acmicpc.net/problem/15663 (N과 M (9))
 * @classfication: backtracking
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.06.08 (O)
 **/
public class Q15663 {
    static int N;
    static int M;
    static int arr[];
    static int memo[];
    static boolean visited[];
    static HashSet<List<Integer>> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        set = new LinkedHashSet<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        memo = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);

        dfs(0);
        System.out.print(printAnswer());
    }

    private static void dfs(int depth) {
        if(depth == M) {
            set.add(Arrays.stream(memo).boxed().collect(Collectors.toList()));
            return;
        }

        for(int i=0;i<N;i++) {
            if(visited[i] == false) {
                memo[depth] = arr[i];
                visited[i] = true;
                dfs(depth+1);
                visited[i] = false;
            }

        }
    }

    private static String printAnswer() {
        Iterator<List<Integer>> iterator = set.iterator();
        StringBuilder answer = new StringBuilder();

        while(iterator.hasNext()) {
            for(int i : iterator.next()) {
                answer.append(i).append(' ');
            }
            answer.append('\n');
        }

        return answer.toString();
    }
}
