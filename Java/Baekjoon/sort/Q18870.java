package Baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/Q18870 (좌표 압축)
 *@classfication: sort
 **/
public class Q18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] sortedArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for(int i=0;i<N;i++)
            arr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sortedArr);

        HashMap<Integer, Integer> hm = new LinkedHashMap<>();

        int rank = -1;
        for(int x : sortedArr)
            if(! hm.containsKey(x))
                hm.put(x, ++rank);

        StringBuilder sb = new StringBuilder();

        for(int x : arr)
            sb.append(hm.get(x)).append(' ');

        System.out.println(sb);
    }
}
