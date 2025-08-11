#include <iostream>
#include <string>
using namespace std;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12904 (가장 긴 팰린드롬)
 * @classification: two pointer
 * @문제 푼 날짜 (자력으로 풂?): 25.08.11 (X)
 **/
int answer = 0;

int get_size(string& s, int str, int end)
{
    int size = str == end ? -1 : 0;
    while(str >= 0 && end < s.size() && s[str] == s[end])
    {
        str--;
        end++;
        size+=2;
    }
    
    return size;
}

int solution(string s)
{
    for(int i=0;i<s.size();i++)
    {
        answer = max(answer, get_size(s, i, i));
        answer = max(answer, get_size(s, i, i+1));
    }

    return answer;
}