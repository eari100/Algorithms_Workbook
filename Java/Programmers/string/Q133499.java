package Programmers.string;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/133499 (옹알이2)
 * @classification: string
 * @문제 푼 날짜 (자력으로 풂?): 24.03.16 (O)
 **/
public class Q133499 {
    public int solution(String[] babbling) {
        int answer = 0;
        final String aya = "aya", ye = "ye", woo = "woo", ma = "ma";

        for(String b : babbling) {
            int str = 0;
            boolean available = true;

            while(str < b.length()) {
                if(str+2 <= b.length()) {
                    String subStr1 = b.substring(str, str+2);

                    if(subStr1.equals(ye)) {
                        if(str-2 >= 0 && b.substring(str-2, str).equals(ye)) {
                            available = false;
                            break;
                        } else {
                            str += 2;
                            continue;
                        }
                    }

                    if(subStr1.equals(ma)) {
                        if(str-2 >= 0 && b.substring(str-2, str).equals(ma)) {
                            available = false;
                            break;
                        } else {
                            str += 2;
                            continue;
                        }
                    }
                }

                if(str+3 < b.length()) {
                    String subStr2 = b.substring(str, str+3);

                    if(subStr2.equals(aya)) {
                        if(str-3 >= 0 && b.substring(str-3, str).equals(aya)) {
                            available = false;
                            break;
                        } else {
                            str += 3;
                            continue;
                        }
                    }

                    if(subStr2.equals(woo)) {
                        if(str-3 >= 0 && b.substring(str-3, str).equals(woo)) {
                            available = false;
                            break;
                        } else {
                            str += 3;
                            continue;
                        }
                    }
                }

                available = false;
                break;
            }

            if(available) {
                ++answer;
            }
        }

        return answer;
    }
}
