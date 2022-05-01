package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *@source: https://www.acmicpc.net/problem/20291 (파일 정리)
 *@classfication: implementation, TreeMap
 **/
public class Q20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> dic = new TreeMap<>();

        for(int i=Integer.parseInt(br.readLine());i>0;i--) {
            String file = br.readLine();
            String[] fileArr = file.split("\\.");

            if(dic.containsKey(fileArr[1])) {
                dic.put(fileArr[1], dic.get(fileArr[1])+1);
            } else {
                dic.put(fileArr[1], 1);
            }
        }
        br.close();

        for(Map.Entry<String, Integer> entry : dic.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
