package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @source: https://www.acmicpc.net/problem/2668 (숫자고르기)
 * @classification: dfs
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.15 (O, 사이클의 특성을 이해하지 못해서 visited를 초기화하지 않음)
 **/
// todo: 업솔빙
public class Q2668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n+1];
        boolean[] visited = new boolean[n+1];
        ArrayList<Integer> keys = new ArrayList<>();

        for(int i=1;i<=n;i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        for(int i=1;i<=n;i++) {
            int curr = nums[i];

            if(i == curr) {
                visited[i] = true;
                keys.add(i);
            } else {
                HashSet<Integer> set = new HashSet<>();
                boolean isMatch = true;

                int index = i;
                while( true ) {
                    if(visited[index] || set.contains(index)) {
                        isMatch = false;
                        break;
                    }

                    set.add(index);
                    index = nums[index];

                    if(i == index) {
                        break;
                    }
                }

                if(isMatch) {
                    for(int key : set) {
                        visited[key] = true;
                        keys.add(key);
                    }
                }
            }
        }

        Collections.sort(keys);

        StringBuilder result = new StringBuilder();
        result.append(keys.size()).append('\n');

        for(int key : keys) {
            result.append(key).append('\n');
        }

        System.out.print(result);
    }
}
