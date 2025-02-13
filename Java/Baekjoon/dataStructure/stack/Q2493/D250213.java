package Baekjoon.dataStructure.stack.Q2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2493 (탑)
 * @classfication: stack
 * @문제 푼 날짜 (자력으로 풂?): 25.02.13 (O)
 **/
public class D250213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stk = new Stack<>();
        stk.push(new int[]{n, arr[n-1]});

        int[] answer = new int[n];

        for(int i=n-2;i>=0;i--) {
            int[] peek = stk.peek();
            int prev_index = peek[0];
            int prev_num = peek[1];

            int curr_index = i + 1;
            int curr_num = arr[i];

            // 같은?
            if(prev_num > curr_num) {
                stk.push(new int[]{curr_index, curr_num});
            } else {
                while( !stk.isEmpty() ) {
                    int[] p = stk.peek();
                    int p_index = p[0];
                    int p_num = p[1];

                    if(p_num > curr_num) {
                        break;
                    }

                    stk.pop();
                    answer[p_index - 1] = curr_index;
                }
                stk.push(new int[]{curr_index, curr_num});
            }
        }

        br.close();

        StringBuilder re = new StringBuilder();

        for(int a : answer) {
            re.append(a).append(" ");
        }

        System.out.println(re);
    }
}
