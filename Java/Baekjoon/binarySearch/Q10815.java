package Baekjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 *@source: https://www.acmicpc.net/problem/10815
 *@classfication: binary search
 **/
public class Q10815 {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nArr = new int[N];
        for(int i=0;i<N;i++)
            nArr[i] = sc.nextInt();

        Arrays.sort(nArr);

        int M = sc.nextInt();
        for(int i=0;i<M;i++)
            binarySearch(0, nArr.length-1, sc.nextInt(), nArr);

        sc.close();
        System.out.print(result);
    }

    private static void binarySearch(int str, int end, int target, int[] nArr) {
        while(str<=end) {
            int mid = (str+end)/2;

            if(nArr[mid]==target) {
                result.append("1 ");
                return;
            }
            else if(nArr[mid]>target) end = --mid;
            else if(nArr[mid]<target) str = ++mid;
        }
        result.append("0 ");
    }
}
