package Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/12033 (김인천씨의 식료품가게 (Small))
 * @classfication: brute-force, binary search
 * @reference: https://www.acmicpc.net/source/23323117 (Collections.binarySearch() 활용)
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.05.22 (O)
 **/
public class Q12033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int i=1;i<=T;i++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> papers = new ArrayList<>();
            int[] discountArr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n*2;j++) {
                papers.add(Integer.valueOf(st.nextToken()));
            }

            int idx = -1;
            for(int j=0;j<papers.size()-1;j++) {
                int x = papers.get(j);
                for(int k=j+1;k<papers.size();k++) {
                    int y = papers.get(k);

                    if(x == y*0.75) {
                        discountArr[++idx] = x;
                        papers.set(k, -1);
                        break;
                    }
                }
            }

            answer.append("Case #"+i+": ");

            for(int d : discountArr)
                answer.append(d+" ");

            answer.append('\n');
        }

        System.out.print(answer);
    }
}
