package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2816 (디지털 티비)
 * @classfication: implementation, constitutive
 * @문제 푼 날짜 (자력으로 풂?): 23.02.19 (O)
 **/
public class Q2816 {
    static int pointer = 0;
    static StringBuilder moveLog = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] channels = new String[N];

        for(int i=0;i<N;i++)
            channels[i] = br.readLine();

        br.close();

        findChannel(channels,"KBS1");
        moveChannel(channels, 0);
        findChannel(channels,"KBS2");
        moveChannel(channels, 1);

        System.out.print(moveLog);
    }

    private static void findChannel(String[] channels, String channel) {
        for(int i=0;i<channels.length;i++) {
            if(channels[i].equals(channel))
                break;

            ++pointer;
            moveLog.append('1');
        }
    }

    private static void moveChannel(String[] channels, int targetNumber) {
        while(pointer > targetNumber) {
            swapChannel(channels);
            --pointer;
            moveLog.append('4');
        }
    }

    private static String[] swapChannel(String[] channels) {
        String tmp = channels[pointer];
        channels[pointer] = channels[pointer-1];
        channels[pointer-1] = tmp;

        return channels;
    }
}
