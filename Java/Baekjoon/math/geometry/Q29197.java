package Baekjoon.math.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/29197 (아침 태권도)
 * @classfication: geometry, math
 * @문제 푼 날짜 (자력으로 풂?): 23.08.18 (X)
 * @reference: https://solved.ac/arena/4/editorial
 **/
// todo: 기울기는 탄젠트로 구하는 방법으로 다시 풀어볼 것 (Math.atan2 메서드 이용)
public class Q29197 {
    final static double x1 = 0, y1 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashSet<Double> 양의_기울기 = new HashSet<>();
        HashSet<Double> 음의_기울기 = new HashSet<>();

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            double 기울기 = (x2 - x1) / (y2 - y1);

            if(y2 > 0) {
                양의_기울기.add(기울기);
            } else if(y2 < 0) {
                음의_기울기.add(기울기);
            } else if(y2 == 0) {
                if(x2 > 0) {
                    양의_기울기.add(기울기);
                } else {
                    음의_기울기.add(기울기);
                }
            }
        }

        br.close();

        int sum = 양의_기울기.size() + 음의_기울기.size();

        System.out.print(sum);
    }
}
