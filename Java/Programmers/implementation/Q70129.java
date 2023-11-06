package Programmers.implementation;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/70129 (이진 변환 반복하기)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.11.07 (O)
 * @referece: String.replaceAll(), Integer.toBinaryString() 을 이용한 풀이 (https://school.programmers.co.kr/learn/courses/30/lessons/70129/solution_groups?language=java)
 **/
public class Q70129 {
    int removeZeroCnt = 0;

    public int[] solution(String s) {
        int convertCnt = 0;

        while( !s.equals("1") ) {
            String rz = removeZero(s);
            s = convertBinaryScale(rz.length());
            ++convertCnt;
        }

        return new int[]{convertCnt, removeZeroCnt};
    }

    private String removeZero(String s) {
        StringBuilder result = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(c == '0') {
                ++removeZeroCnt;
            } else if(c == '1') {
                result.append(c);
            }
        }

        return result.toString();
    }

    private String convertBinaryScale(int len) {
        StringBuilder result = new StringBuilder();

        while(len > 1) {
            result.append(len % 2);
            len /= 2;
        }

        result.append('1');

        return result.reverse().toString();
    }
}
