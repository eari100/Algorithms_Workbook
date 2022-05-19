package Baekjoon.dataStructure.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/2910
 *@classfication: hash, stable sort
 **/
public class Q2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new LinkedHashMap<>(n); // 초기 용량 지정, LinkedHashMap을 이용한 stable sort
        st = new StringTokenizer(br.readLine());
        br.close();

        while(st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());

            if(map.containsKey(x)) map.put(x,map.get(x) + 1);
            else map.put(x, 1);
        }

        StringBuilder sb = new StringBuilder();

        map.entrySet().stream()
                .sorted((m1, m2) -> m2.getValue() - m1.getValue())
                .forEach(m -> sb.append( (m.getKey()+" ").repeat(m.getValue()) ));

        System.out.print(sb);
    }
}
