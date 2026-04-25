/**
* @source: https://school.programmers.co.kr/learn/courses/30/lessons/148653 (마법의 엘리베이터)
* @classification: greedy
* @문제 푼 날짜 (자력으로 풂?): 26.04.25 (X)
**/
int solution(int storey)
{
    int answer = 0;
    
    while(storey)
    {
        int mod = storey % 10;
        storey /= 10;
        
        if(mod == 5)
        {
            answer += 5;
            
            if(storey % 10 >= 5)
            {
                storey++;
            }
        }
        else if(mod >= 6)
        {
            answer += 10 - mod;
            storey++;
        }
        else
        {
            answer += mod;
        }
    }
    
    return answer;
}