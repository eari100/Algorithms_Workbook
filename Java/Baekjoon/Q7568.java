package Baekjoon;

import java.io.*;
import java.util.*;

/**
 *@source: https://www.acmicpc.net/problem/7568 (덩치)
 *@classfication: brute force
 **/
public class Q7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        List<Human> humans = new ArrayList<>();
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            humans.add(new Human(weight, height));
        }
        br.close();

        for(Human h1 : humans) {
            int ranking = 1;
            for(Human h2 : humans) {
                ranking += compareHuman(h1, h2);
            }
            result.append(ranking).append(" ");
        }

        System.out.print(result);
    }

    public static class Human {
        private int weight;
        private int height;

        public Human(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }
    }

    private static int compareHuman(Human h1, Human h2) {
        return h1.getWeight() < h2.getWeight() && h1.getHeight() < h2.getHeight() ? 1 : 0;
    }
}
