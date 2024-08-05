package Programmers.implementation;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/67256 (키패드 누르기)
 * @classification: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.05 (O)
 **/
public class Q67256 {
    // immutable
    private int[] left_dir = new int[]{3, 0};
    private int[] right_dir = new int[]{3, 2};

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                move_left(answer, get_point(num));
            } else if (num == 3 || num == 6 || num == 9) {
                move_right(answer, get_point(num));
            } else {
                int[] next_dir = get_point(num);
                int left_diff = get_dist(left_dir, next_dir);
                int right_diff = get_dist(right_dir, next_dir);

                if (left_diff == right_diff) {
                    if (hand.equals("right")) {
                        move_right(answer, next_dir);
                    } else {
                        move_left(answer, next_dir);
                    }
                } else if (left_diff < right_diff) {
                    move_left(answer, next_dir);
                } else {
                    move_right(answer, next_dir);
                }
            }
        }

        return answer.toString();
    }

    private void move_left(StringBuilder answer, int[] next_dir) {
        left_dir = next_dir;
        answer.append('L');
    }

    private void move_right(StringBuilder answer, int[] next_dir) {
        right_dir = next_dir;
        answer.append('R');
    }

    private int[] get_point(int num) {
        int num2 = num == 0 ? 10 : num - 1;
        return new int[]{num2 / 3, num2 % 3};
    }

    private int get_dist(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }
}
