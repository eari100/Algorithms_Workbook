package Baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/1822 (차집합)
 * @classification: binary search
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.10.11 (O)
 **/
public class Q1822 {
    static int memoStr = 0;
    static int checkCount = 0;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        br.readLine();

        int[] A = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[] B = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        checked = new boolean[A.length];

        Arrays.sort(A);
        Arrays.sort(B);

        for(int target : B) {
            binarySearch(A, target);
        }

        int differenceSize = A.length - checkCount;
        result.append(differenceSize).append('\n');

        for(int i=0;i<A.length;i++) {
            if( !checked[i] )
            result.append(A[i]).append(' ');
        }

        System.out.print(result);
        br.close();
    }

    private static void binarySearch(int[] A, int target) {
        int str = memoStr;
        int end = A.length - 1;

        while(str <= end) {
            int mid = (str + end) / 2;

            if(A[mid] < target) {
                str = mid + 1;
            } else if(A[mid] > target) {
                end = mid - 1;
            } else {
                memoStr = mid + 1;
                checked[mid] = true;
                ++checkCount;
                break;
            }
        }
    }
}
