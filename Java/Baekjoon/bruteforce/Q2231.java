package Baekjoon.bruteforce;

import java.io.*;

public class Q2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] arr = new int[N+1];

        for(int i=1;i<arr.length;i++) {
            String s = Integer.toString(i);
            int result = i;

            for(char c : s.toCharArray()) {
                result += Character.getNumericValue(c);
            }

            arr[i] = result;
        }

        System.out.print(findIndex(arr, N));
    }

    private static int findIndex(int[] arr, int N) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == N) {
                return i;
            }
        }

        return 0;
    }
}
