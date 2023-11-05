package Programmers.graph.dfs;

import java.util.Arrays;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/43164 (여행경로)
 * @classification: dfs
 * @문제 푼 날짜 (자력으로 풂?): 23.11.05 (O)
 **/
public class Q43164 {
    static boolean done = false;

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        answer[0] = "ICN";
        boolean[] visited = new boolean[tickets.length];
        Arrays.sort(tickets, (t1, t2) -> t1[0].equals(t2[0]) ? t1[1].compareTo(t2[1]) : t1[0].compareTo(t2[0]));

        dfs(answer, tickets, visited, 1);

        return answer;
    }

    private void dfs(String[] answer, String[][] tickets, boolean[] visited, int index) {
        if(index == answer.length) {
            done = true;
            return;
        }

        for(int i=0;i<tickets.length;i++) {
            if(visited[i]) continue;

            String[] ticket = tickets[i];
            String str = ticket[0];
            String end = ticket[1];

            if(str.equals(answer[index-1])) {
                visited[i] = true;
                answer[index] = end;
                dfs(answer, tickets, visited, index+1);

                if(done) break;
            }

            visited[i] = false;
        }
    }
}
