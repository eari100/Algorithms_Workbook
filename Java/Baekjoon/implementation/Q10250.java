package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/10250 (ACM 호텔)
 * @classfication: implementation, math
 * @문제 푼 날짜 (자력으로 풂?): 23.04.23 (O)
 **/
public class Q10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer data = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(data.nextToken());
            int W = Integer.parseInt(data.nextToken());
            int N = Integer.parseInt(data.nextToken());

            int share = N / H;
            int remain = N % H;
            int roomFrontNumber = getRoomFrontNumber(remain, H);
            String roomBackNumber = getRoomBackNumber(share, remain);

            result.append(roomFrontNumber).append(roomBackNumber).append('\n');
        }

        br.close();

        System.out.print(result);
    }

    private static int getRoomFrontNumber(int remain, int H) {
        return remain == 0 ? H : remain;
    }

    private static String getRoomBackNumber(int share, int remain) {
        int roomBackNumber = remain == 0 ? share : share + 1;
        String 두_자리수로_이뤄진_RoomBackNumber = roomBackNumber < 10 ? "0" + roomBackNumber : String.valueOf(roomBackNumber);

        return 두_자리수로_이뤄진_RoomBackNumber;
    }
}
