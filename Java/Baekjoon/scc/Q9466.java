package Baekjoon.scc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/9466 (텀 프로젝트)
 * @classification: SCC
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.06.30 (자력솔 하긴 했는데 SSC 참고하면서 어거지로 풂)
 **/
// todo: dfs로 업솔빙
public class Q9466 {
    static Stack<Integer> stack;
    static int[] orders;
    static int sccItemCnt;
    static int[] grid;
    static int sccCnt;
    static int order = 0;
    static boolean[] isSccItem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            grid = new int[n];
            stack = new Stack<>();
            orders = new int[n];
            sccCnt = 0;
            isSccItem = new boolean[n];

            for(int i=0;i<n;i++) {
                int num = Integer.parseInt(st.nextToken()) - 1;
                grid[i] = num;
            }

            for(int i=0;i<grid.length;i++) {
                if(orders[i] == 0) {
                    scc(i);
                }
            }

            result.append(sccCnt).append('\n');
        }

        br.close();

        System.out.print(result);
    }

    private static int scc(int idx) {
        orders[idx] = ++order;
        int root = orders[idx];
        stack.add(idx);
        int next = grid[idx];

        if(idx == next) {
            stack.pop();
            isSccItem[idx] = true;
            return root;
        }

        if(orders[next] == 0) {
            root = Math.min(root, scc(next));
        } else if( !isSccItem[next] ) {
            root = Math.min(root, orders[next]);
        }

        if(root == orders[idx]) {
            sccItemCnt = 0;
            while( !stack.isEmpty() ) {
                int pop = stack.pop();
                isSccItem[pop] = true;
                ++sccItemCnt;

                if(idx == pop) {
                    break;
                }
            }

            if(sccItemCnt == 1) {
                ++sccCnt;
            }
        }

        return root;
    }
}
