package Baekjoon.scc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2150 (Strongly Connected Component)
 * @classification: SCC
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.04.29 (X)
 **/
public class Q2150 {
    static ArrayList<Integer>[] graph;
    static Stack<Integer> stack = new Stack<>();
    static int sccCnt = 0;
    static ArrayList<Integer>[] sccList;
    static int[] orders;
    static int order = 0;
    static boolean[] isScc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int v = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
        graph = new ArrayList[v+1];
        sccList = new ArrayList[v+1];
        orders = new int[v+1];
        isScc = new boolean[v+1];

        for(int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
            sccList[i] = new ArrayList<>();
        }

        for(int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        br.close();

        for(int i = 1; i <= v; i++) {
            if(orders[i] == 0) {
                SCC(i);
            }
        }

        result.append(sccCnt).append('\n');

        for(ArrayList<Integer> sccItems : sccList) {
            if(sccItems.size() == 0) continue;

            for(int sccItem : sccItems) {
                result.append(sccItem).append(" ");
            }
            result.append(-1).append("\n");
        }

        System.out.print(result);
    }

    private static int SCC(int idx) {
        orders[idx] = ++order;
        stack.add(idx);
        ArrayList<Integer> network = graph[idx];
        int root = orders[idx];

        for(Integer node : network) {
            if(orders[node] == 0) {
                root = Math.min(root, SCC(node));
            } else if( !isScc[node] ) {
                root = Math.min(root, orders[node]);
            }
        }

        if(root == orders[idx]) {
            ++sccCnt;

            ArrayList<Integer> tmpScc = new ArrayList<>();

            while( !stack.isEmpty() ) {
                int pop = stack.pop();
                isScc[pop] = true;

                tmpScc.add(pop);

                if(pop == idx) {
                    break;
                }
            }

            Collections.sort(tmpScc);
            sccList[tmpScc.get(0)] = tmpScc;
        }

        return root;
    }
}
