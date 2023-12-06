package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/9017 (크로스 컨트리)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.12.06 (O)
 **/
// todo: 최적화할 것
public class Q9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for(int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N];
            int[] accumulate = new int[N];
            HashMap<Integer, ArrayList<Integer>> teams = new HashMap<>();
            HashMap<Integer, Integer> teamScore = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int n=0;n<N;n++) {
                int team = Integer.parseInt(st.nextToken());
                rank[n] = team;

                if( !teams.containsKey(team) ) {
                    teams.put(team, new ArrayList<>());
                }

                teams.get(team).add(n);
                accumulate[n] = teams.get(team).size();
            }

            int score = 1;
            for(int i=0;i<rank.length;i++) {
                int team = rank[i];
                int personCnt = teams.get(team).size();

                if(personCnt == 6) {
                    if(accumulate[i] < 5) {
                        teamScore.put(team, teamScore.getOrDefault(team, 0) + score );
                    }
                    ++score;
                }
            }

            ArrayList<Integer> tieTeams = new ArrayList<>();

            int bestScore = Integer.MAX_VALUE;
            for(Map.Entry<Integer, Integer> entry : teamScore.entrySet()) {
                if(bestScore > entry.getValue()) {
                    bestScore = entry.getValue();
                    tieTeams = new ArrayList<>();
                    tieTeams.add(entry.getKey());
                }  else if(bestScore == entry.getValue()) {
                    tieTeams.add(entry.getKey());
                }
            }

            if(tieTeams.size() == 1) {
                result.append(tieTeams.get(0)).append('\n');
            } else {
                L1: for(int i=0;i<rank.length;i++) {
                    int team = rank[i];
                    int personCnt = teams.get(team).size();

                    if(personCnt == 6 && accumulate[i] == 5) {
                        for(int tieTeam : tieTeams) {
                            if(tieTeam == team) {
                                result.append(tieTeam).append('\n');
                                break L1;
                            }
                        }
                    }
                }
            }
        }

        br.close();

        System.out.print(result);
    }
}
