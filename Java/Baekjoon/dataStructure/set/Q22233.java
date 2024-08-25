package Baekjoon.dataStructure.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/22233 (가희와 키워드)
 * @classification: set
 * @문제 푼 날짜 (자력으로 풂?): 24.08.25 (O)
 **/
// todo: c++로 풀면 어렵다고 함
public class Q22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int keywordCnt = Integer.parseInt(st.nextToken());
        int blogCnt = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < keywordCnt; i++) {
            set.add(br.readLine());
        }

        for(int i=0;i<blogCnt;i++) {
            String[] k = br.readLine().split(",");

            for(String s : k)
                set.remove(s);

            result.append(set.size()).append("\n");
        }

        br.close();

        System.out.print(result);
    }
}
