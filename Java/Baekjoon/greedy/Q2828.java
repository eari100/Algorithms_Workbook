package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int W = 1;
        int result = 0;

        for(int i=0;i<J;i++) {
            int d = Integer.parseInt(br.readLine());

            if(d < W) {
                int leftDist = W-d;

                W -= leftDist;
                M -= leftDist;
                result += leftDist;
            } else if(d > M) {
                int rightDist = d-M;

                W += rightDist;
                M += rightDist;
                result += rightDist;
            }
        }

        br.close();

        System.out.print(result);
    }
}
