package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/13717 (포켓몬 GO)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.12.28 (O)
 **/
public class Q13717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int payBack = 2;
        int sumEvolutions = 0, mostEvolutions = 0;
        String mostPokemon = "";

        for(int i=0;i<N;i++) {
            String pokemon = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int need = Integer.parseInt(st.nextToken()), have = Integer.parseInt(st.nextToken());
            int evolutions = 0;

            while(have / need > 0) {
                have -= need;
                have += payBack;
                ++evolutions;
            }

            sumEvolutions += evolutions;

            if(evolutions > mostEvolutions) {
                mostEvolutions = evolutions;
                mostPokemon = pokemon;
            }
        }

        br.close();

        StringBuilder result = new StringBuilder();
        result.append(sumEvolutions).append('\n').append(mostPokemon);

        System.out.print(result);
    }
}
