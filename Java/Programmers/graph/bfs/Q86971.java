package Programmers.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/86971 (전력망을 둘로 나누기)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.11.06 (O)
 * @referece: dfs를 활용한 더 좋은 풀이 (https://school.programmers.co.kr/learn/courses/30/lessons/86971/solution_groups?language=java&type=all)
 **/
public class Q86971 {
    public int solution(int n, int[][] wires) {
        int minAnswer = wires.length;

        for(int exclude=0;exclude<wires.length;exclude++) {
            int firstConnect = 0, secondConnect = 0;
            boolean[] visited = new boolean[wires.length];

            for(int index=0;index<wires.length;index++) {
                if(index == exclude) continue;
                if(visited[index]) continue;

                int connect = bfs(index, wires, visited, exclude);

                if(firstConnect == 0) {
                    firstConnect = connect;
                } else {
                    secondConnect = connect;
                }
            }

            int answer = Math.abs(firstConnect - secondConnect);
            minAnswer = Math.min(minAnswer, answer);
        }

        return minAnswer;
    }

    private int bfs(int index, int[][] wires, boolean[] visited, int exclude) {
        int connect = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(wires[index]);
        visited[index] = true;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int a1 = poll[0], b1 = poll[1];

            for(int i=0;i<wires.length;i++) {
                if(exclude == i) continue;
                if(visited[i]) continue;

                int[] wire = wires[i];
                int a2 = wire[0], b2 = wire[1];

                if(a1 == a2 || a1 == b2 || b1 == a2 || b1 == b2) {
                    queue.offer(wire);
                    visited[i] = true;
                    ++connect;
                }
            }
        }

        return connect;
    }
}
