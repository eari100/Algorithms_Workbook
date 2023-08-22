package Programmers.string;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/49993 (스킬트리)
 * @classfication: string
 * @문제 푼 날짜 (자력으로 풂?): 23.08.22 (O)
 **/
// todo: O(N^2) 풀이, 정규 표현식으로 풀어볼 것
public class Q49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String st : skill_trees) {
            int skillIdx = 0;
            boolean flag = false;

            L1: for(char st_c : st.toCharArray()) {
                for(char s : skill.toCharArray()) {
                    if(s == st_c) {
                        if(skill.charAt(skillIdx) != s) {
                            flag = true;
                            break L1;
                        }

                        ++skillIdx;
                    }
                }
            }
            if( !flag )
                ++answer;
        }

        return answer;
    }
}
