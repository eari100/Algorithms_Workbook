package Baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/28449 (누가 이길까)
 * @classfication: binary search
 * @문제 푼 날짜 (자력으로 풂?): 23.08.15 (?, 힌트 열람)
 **/
// todo: 매우 비효율적으로 풂 (좋은 코드 보고 익힐 것)
public class Q28449 {
    static long nWinSum = 0;
    static long mWinSum = 0;
    static long draw = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nArr = new int[N];
        int[] mArr = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++)
            nArr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++)
            mArr[i] = Integer.parseInt(st.nextToken());

        br.close();

        Arrays.sort(nArr);
        Arrays.sort(mArr);

        binarySearchMatching(nArr, mArr);

        StringBuilder result = new StringBuilder();
        result.append(nWinSum).append(' ').append(mWinSum).append(' ').append(draw);
        System.out.print(result);
    }

    private static void binarySearchMatching(int[] nArr, int[] mArr) {
        int left = 0;
        int mid = 0;
        int right = mArr.length - 1;

        for(int n : nArr) {
            int tempDraw = 0;
            boolean flag = true;

            while(left <= right) {
                mid = (right + left) / 2;
                int m = mArr[mid];

                if(n == m) {
                    flag = false;
                    int mid2 = mid;
                    ++tempDraw;

                    while(mid2-- > 0) {
                        m = mArr[mid2];
                        if(m != n) break;
                        ++tempDraw;
                    }

                    nWinSum += mid2 + 1;

                    while(mid++ < mArr.length - 1) {
                        m = mArr[mid];
                        if(m != n) break;
                        ++tempDraw;
                    }

                    mWinSum += mArr.length - mid;
                    draw += tempDraw;
                    left = mid - 1;
                    right = mArr.length - 1;
                    break;
                } else if(n > m) {
                    left = mid + 1;
                } else if(n < m) {
                    right = mid - 1;
                }
            }

            if(flag) {
                int mWin = mArr.length - left;
                mWinSum += mWin;
                nWinSum += mArr.length - mWin;
                left = mid;
                right = mArr.length - 1;
            }
        }
    }
}
