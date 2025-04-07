package Baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/3541 (상근타워)
 * @classification: binary search
 * @문제 푼 날짜 (자력으로 풂?): 25.03.28 (X, 실수로 태그 확인함)
 * @더 좋은 풀이: https://www.acmicpc.net/source/242325
 **/
public class Q3541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int str = 0, end = n;

            while(str <= end) {
                int mid = (str + end) / 2;
                int result = u * mid - d * (n - mid);

                if(result > 0) {
                    min = Math.min(min, result);
                    end = mid - 1;
                } else {
                    str = mid + 1;
                }
            }
        }

        br.close();

        System.out.print(min);
    }
}
