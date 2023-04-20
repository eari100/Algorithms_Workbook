package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2884 (알람 시계)
 * @classfication: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.04.20 (O)
 **/
public class Q2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer time = new StringTokenizer(br.readLine());
        br.close();

        int hour = Integer.parseInt(time.nextToken());
        int minute = Integer.parseInt(time.nextToken());

        LocalTime wakeupTime = LocalTime.of(hour, minute);

        LocalTime alarmTime = wakeupTime.minusMinutes(45);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H m");

        System.out.print(alarmTime.format(formatter));
    }
}
