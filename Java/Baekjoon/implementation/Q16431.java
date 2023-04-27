package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/16431 (베시와 데이지)
 * @classfication: implementation
 * @referece: https://www.acmicpc.net/source/10756421(더 좋은 풀이)
 * @문제 푼 날짜 (자력으로 풂?): 23.04.27 (O)
 **/
public class Q16431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String result = "";
        int bessieMove = 0, daisyMove = 0;

        int bR = Integer.parseInt(st.nextToken());
        int bC = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int dR = Integer.parseInt(st.nextToken());
        int dC = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int jR = Integer.parseInt(st.nextToken());
        int jC = Integer.parseInt(st.nextToken());

        br.close();

        int 대각선으로_움직인_거리1 = Math.abs(bC - jC);
        int 대각선으로_움직인_거리2 = Math.abs(bR - jR);

        if(대각선으로_움직인_거리1 < 대각선으로_움직인_거리2) {
            int 직선으로_움직인_거리 = Math.min(Math.abs((bR-대각선으로_움직인_거리1) - jR), Math.abs((bR+대각선으로_움직인_거리1) - jR));
            bessieMove = 대각선으로_움직인_거리1 + 직선으로_움직인_거리;
        } else {
            int 직선으로_움직인_거리  =Math.min(Math.abs((bC-대각선으로_움직인_거리2) - jC), Math.abs((bC+대각선으로_움직인_거리2) - jC));
            bessieMove = 대각선으로_움직인_거리2 + 직선으로_움직인_거리;
        }

        daisyMove = Math.abs(jR - dR) + Math.abs(jC - dC);

        if(bessieMove == daisyMove) result = "tie";
        else if(bessieMove > daisyMove) result = "daisy";
        else if(bessieMove < daisyMove) result = "bessie";

        System.out.print(result);
    }
}
