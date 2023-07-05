package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @source: https://www.acmicpc.net/problem/1058 (친구)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.07.06 (O, 예외 케이스가 없도록 검증하는 습관을 들일 것)
 **/
// TODO: 2023-07-06 플로이드-와샬, dfs, bfs 로 풀어볼 것 
public class Q1058 {
    static int maxTwoFriendCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int friendCnt = Integer.parseInt(br.readLine());
        ArrayList<Boolean>[] networks = new ArrayList[friendCnt];


        for(int i=0;i<friendCnt;i++) {
            String relation = br.readLine();

            networks[i] = new ArrayList();

            for(char c : relation.toCharArray()) {
                networks[i].add(c == 'Y' ? true : false);
            }
        }

        br.close();

        for(int i=0;i<networks.length;i++) {
            searchNetwork(networks, i);
        }

        System.out.print(maxTwoFriendCount);
    }

    private static void searchNetwork(ArrayList<Boolean>[] networks, int networkIdx) {
        Set<Integer> twoFriendSet = new HashSet<>();

        ArrayList<Boolean> network = networks[networkIdx];

        for(int i=0;i<network.size();i++) {
            if(network.get(i) && networkIdx != i) {
                twoFriendSet.add(i);

                ArrayList<Boolean> network2 = networks[i];

                for(int j=0;j<network2.size();j++) {
                    if(network2.get(j) && networkIdx != j) {
                        twoFriendSet.add(j);
                    }
                }
            }
        }

        maxTwoFriendCount = Math.max(maxTwoFriendCount, twoFriendSet.size());
    }
}
