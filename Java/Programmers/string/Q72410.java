package Programmers.string;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/72410 (2021 KAKAO BLIND RECRUITMENT > 신규 아이디 추천)
 * @classification: string
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.10 (O)
 **/
public class Q72410 {
    public String solution(String new_id) {
        String step1_id = step1(new_id);
        String step2_id = step2(step1_id);
        String step3_id = step3(step2_id);
        String step4_id = step4(step3_id);
        String step5_id = step5(step4_id);
        String step6_id = step6(step5_id);
        String step7_id = step7(step6_id);

        return step7_id;
    }

    private String step1(String new_id) {
        return new_id.toLowerCase();
    }

    private String step2(String new_id) {
        StringBuilder result = new StringBuilder();

        for(char c : new_id.toCharArray()) {
            if(isLowerCase(c) || isNumber(c) || c == '-' || c == '_' || c== '.') {
                result.append(c);
            }
        }

        return result.toString();
    }

    private boolean isLowerCase(char c) {
        return (int) c >= (int) 'a' && (int) c <= (int) 'z';
    }

    private boolean isNumber(char c) {
        return (int) c >= (int) '0' && (int) c <= (int) '9';
    }

    private String step3(String new_id) {
        StringBuilder result = new StringBuilder();

        for(int i=0;i<new_id.length();i++) {
            if(i == 0) {
                result.append(new_id.charAt(i));
            } else {
                char prev = new_id.charAt(i-1), curr = new_id.charAt(i);

                if(prev == '.' && curr == '.') {
                    continue;
                }

                result.append(curr);
            }
        }

        return result.toString();
    }

    private String step4(String new_id) {
        StringBuilder result = new StringBuilder();

        for(int i=0;i<new_id.length();i++) {
            if(i == 0  || i == new_id.length()-1) {
                if(new_id.charAt(i) != '.') {
                    result.append(new_id.charAt(i));
                }
            } else {
                result.append(new_id.charAt(i));
            }
        }

        return result.toString();
    }

    private String step5(String new_id) {
        return new_id.isEmpty() ? "a" : new_id;
    }

    private String step6(String new_id) {
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);

            if(new_id.charAt(new_id.length()-1) == '.') {
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }

        return new_id;
    }

    private String step7(String new_id) {
        char lastChar = new_id.charAt(new_id.length()-1);
        while(new_id.length() <= 2) {
            new_id += lastChar;
        }

        return new_id;
    }
}
