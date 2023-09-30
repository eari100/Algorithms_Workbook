package Atcoder.AtCoder_Biginner_Contest_322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://atcoder.jp/contests/abc322/tasks/abc322_c (C - Festival)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.09.30 (O)
 **/
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] fireworks = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        br.close();

        int fireworkIdx = 0;

        for(int i=1;i<=N;i++) {
            int fireworkDay = fireworks[fireworkIdx];

            System.out.println(fireworkDay - i);

            if(i == fireworkDay) {
                ++fireworkIdx;
            }
        }
    }
}
