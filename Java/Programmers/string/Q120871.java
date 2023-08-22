package Programmers.string;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/120871 (저주의 숫자 3)
 * @classfication: string, implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.22 (O)
 **/
// todo: 깔끔한 코드로 바꿀 것
public class Q120871 {
    public static void main(String[] args) {
        Q120871 q = new Q120871();
        System.out.println(q.solution(15));
    }
    public int solution(int n) {
        int answer = 0;

        for(int i=1;i<=n;i++) {
            ++answer;
            if(answer % 3 == 0) {
                ++answer;
            }

            while(true) {
                String str = String.valueOf(answer);
                boolean flag = false;

                for(char c : str.toCharArray()) {
                    if(c == '3') {
                        ++answer;
                        flag = true;
                        break;
                    }
                }

                if( !flag ) break;
            }

            if(answer % 3 == 0) {
                ++answer;
            }

            System.out.println(answer);
        }

        return answer;
    }
}
