package Baekjoon.string;

import java.io.*;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/9046 (복호화)
 * @classfication: string
 * @reference: https://codechacha.com/ko/java-sort-map/
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.29 (O)
 **/
public class Q9046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            String str = br.readLine();

            HashMap<Character, Integer> hashMap = new HashMap<>();

            for(char c : str.toCharArray()) {
                if(c == ' ') continue;

                if(hashMap.containsKey(c)) hashMap.put(c, hashMap.get(c)+1);
                else hashMap.put(c, 1);
            }

            List<Map.Entry<Character, Integer>> entries = new LinkedList<>(hashMap.entrySet());
            Collections.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());

            if(entries.size() > 1 && entries.get(0).getValue() == entries.get(1).getValue())
                sb.append('?').append('\n');
            else
                sb.append(entries.get(0).getKey()).append('\n');
        }
        br.close();

        System.out.print(sb);
    }
}
