package Programmers.brute_force;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=java (최소직사각형)
 * @classfication: brute force
 * @문제 푼 날짜 (자력으로 풂?): 23.08.29 (O)
 **/
// todo: swap 사용하지 말고 리펙토링
public class Q86491 {
    public int solution(int[][] sizes) {
        int maxW = 0, maxH = 0;

        for(int[] size : sizes) {
            if(size[1] > size[0]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }

            maxW = Math.max(maxW, size[0]);
            maxH = Math.max(maxH, size[1]);
        }

        return maxW * maxH;
    }
}
