package Programmers.implementation.stream;

import java.util.Arrays;

public class Q120891 {
    public int solution(int order) {
        return (int) Arrays.stream(String.valueOf(order).split(""))
                .map(Integer::parseInt)
                .filter(i -> i == 3 || i == 6 || i == 9)
                .count();
    }
}
