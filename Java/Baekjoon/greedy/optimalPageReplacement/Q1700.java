package Baekjoon.greedy.optimalPageReplacement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1700 (멀티탭 스케줄링)
 * @classfication: optimal page replacement, greedy
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.04.13(X)
 * @reference: https://steady-coding.tistory.com/55
 **/
public class Q1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] orders = new int[K];
        boolean[] usedArr = new boolean[K+1];

        st = new StringTokenizer(br.readLine());
        br.close();

        for(int i=0;i<K;i++)
            orders[i] = Integer.parseInt(st.nextToken());

        System.out.print(getSwitching(orders, usedArr, N));
    }

    private static int getSwitching(int[] orders, boolean[] usedArr, int N) {
        int switching = 0;
        int usingCnt = 0;

        for(int ordersIndex=0;ordersIndex<orders.length;ordersIndex++) {
            int order = orders[ordersIndex];

            // 1. 멀티탭에 해당 전자제품이 꽂혀있다면 skip
            if(isContains(usedArr, order)) continue;

            // 2. 멀티탭에 빈 공간이 있다면 추가
            if( !isFullUsed(N, usingCnt) ) {
                usedArr[order] = true;
                ++usingCnt;
            }
            // 3. 멀티탭에 빈 공간이 없다면 꽂혀있는 것 중 하나를 빼고 멀태탭의 주문 제품을 추가한다
            else {
                ArrayList<Integer> 플러그와_추후의_주문이_일치하는_제품_리스트 = 플러그와_추후의_주문이_일치하는_제품_리스트를_반환하다(ordersIndex, usedArr, orders);
                if(멀티탭에_꽂혀있는_모든_전자제품이들_이후에_사용되는가(플러그와_추후의_주문이_일치하는_제품_리스트, N))
                    멀티탭에_꽂혀있는_전자제품_중_가장_나중에_사용하는_전자제품_뽑는다(플러그와_추후의_주문이_일치하는_제품_리스트, usedArr);
                else
                    멀티탭에_꽂혀있는_제품_중_추후에_사용하지_않는_제품은_뺀다(usedArr, 플러그와_추후의_주문이_일치하는_제품_리스트);

                usedArr[order] = true;
                ++switching;
            }
        }

        return switching;
    }

    private static boolean isContains(boolean[] usedArr, int order) {
        return usedArr[order] ? true : false;
    }

    private static boolean isFullUsed(int N, int usingCnt) {
        return N == usingCnt ? true : false;
    }

    private static ArrayList<Integer> 플러그와_추후의_주문이_일치하는_제품_리스트를_반환하다(int ordersIndex, boolean[] usedArr, int[] orders) {
        ArrayList<Integer> 플러그와_추후의_주문이_일치하는_제품_리스트 = new ArrayList<>();
        for(int nextOrderIndex=ordersIndex;nextOrderIndex<orders.length;nextOrderIndex++) {
            int order = orders[nextOrderIndex];

            if(usedArr[order] && !플러그와_추후의_주문이_일치하는_제품_리스트.contains(order))
                플러그와_추후의_주문이_일치하는_제품_리스트.add(order);
        }

        return 플러그와_추후의_주문이_일치하는_제품_리스트;
    }

    private static boolean 멀티탭에_꽂혀있는_모든_전자제품이들_이후에_사용되는가(ArrayList<Integer> 플러그와_추후의_주문이_일치하는_제품_리스트, int N) {
        return 플러그와_추후의_주문이_일치하는_제품_리스트.size() == N;
    }

    private static void 멀티탭에_꽂혀있는_전자제품_중_가장_나중에_사용하는_전자제품_뽑는다(ArrayList<Integer> 플러그와_추후의_주문이_일치하는_제품_리스트, boolean[] usedArr) {
        int remove = 플러그와_추후의_주문이_일치하는_제품_리스트.get(플러그와_추후의_주문이_일치하는_제품_리스트.size() - 1);
        usedArr[remove] = false;
    }

    private static void 멀티탭에_꽂혀있는_제품_중_추후에_사용하지_않는_제품은_뺀다(boolean[] usedArr, ArrayList<Integer> 플러그와_추후의_주문이_일치하는_제품_리스트) {
        for(int remove=1;remove<usedArr.length;remove++) {
            if(usedArr[remove] && !플러그와_추후의_주문이_일치하는_제품_리스트.contains(remove)) {
                usedArr[remove] = false;
                break;
            }
        }
    }
}
