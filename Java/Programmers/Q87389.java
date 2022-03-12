package Programmers;

import java.util.stream.IntStream;

/**
 *@source: https://programmers.co.kr/learn/courses/30/lessons/87389 (나머지가 1이 되는 수 찾기)
 *@classfication:
 **/
public class Q87389 {
    public int solution(int n) {
        return IntStream.range(2, n).filter(x -> n%x == 1).findFirst().orElse(0);
    }
}
