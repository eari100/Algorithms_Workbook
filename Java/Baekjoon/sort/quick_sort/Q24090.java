package Baekjoon.sort.quick_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/24090 (알고리즘 수업 - 퀵 정렬 1)
 * @classification: quick sort
 * @문제 푼 날짜 (자력솔?): 25.06.05 (O)
 **/
public class Q24090 {
    static int[] nums;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        quick_sort(0, n-1);

        System.out.print(-1);
    }

    private static void quick_sort(int str, int end) {
        if(str < end) {
            int q = partition(str, end);
            quick_sort(str, q-1);
            quick_sort(q+1, end);
        }
    }

    private static int partition(int str, int end) {
        int x = nums[end];
        int i = str - 1;

        for(int j=str;j<end;j++) {
            if(nums[j] <= x) {
                i++;
                swap(nums, i, j);
            }
        }

        ++i;

        if(i != end) {
            swap(nums, i, end);
        }

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        --k;
        if(k == 0) {
            if(nums[i] < nums[j]) {
                System.out.print(nums[i] + " " + nums[j]);
            } else {
                System.out.print(nums[j] + " " + nums[i]);
            }

            System.exit(0);
        }
    }
}
