package Programmers.geometry;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/140107 (점 찍기)
 * @classification: geometry
 * @문제 푼 날짜 (자력으로 풂?): 25.05.05 (X)
 **/
// 피타고라스의 정리
// r^2 = (x1 - x2) ^ 2 - (y1 - y2) ^ 2
// y^2 = r^2 - (x1 - x2) ^ 2
public class Q140107 {
    public long solution(int k, int d) {
        long answer = 0;
        double d_pow = Math.pow(d, 2);

        for(long x=0;x<=d;x+=k) {
            double x_pow = Math.pow(x, 2);
            double y_pow = d_pow - x_pow;
            long y_pow_sqrt = (long) Math.sqrt(y_pow);

            answer += y_pow_sqrt / k + 1;
        }

        return answer;
    }
}
