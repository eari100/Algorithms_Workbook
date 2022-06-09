package Baekjoon.implementation;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @source: https://www.acmicpc.net/problem/10699
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.09 (X)
 **/
public class Q10699 {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        System.out.print(format.format(d));
    }
}
