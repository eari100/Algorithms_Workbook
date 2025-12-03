#include <string>
#include <vector>

using namespace std;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12936 (줄 서는 방법)
 * @classification: math
 * @문제 푼 날짜 (자력으로 풂?): 25.12.03 (O)
 **/
bool visited[20+1];

vector<int> solution(int n, long long k)
{
    vector<int> answer;

    int num_cnt = n;
    long long total = 1;
    for(int i=2;i<=n;i++)
    {
        total *= i;
    }

    while(k > 1)
    {
        total /= num_cnt;
        long long share = k / total;
        k %= total;

        long long skip = share;
        if(k)
        {
            skip++;
        }

        int num = 1;

        while(skip)
        {
            if( !visited[num] )
            {
                skip--;

                if(!skip)
                {
                    answer.push_back(num);
                    visited[num] = true;
                }
            }

            num++;
            if(num == n+1)
            {
                num = 1;
            }
        }

        num_cnt--;
    }

    // 정방향
    if(k == 1)
    {
        for(int i=1;i<=n;i++)
        {
            if( !visited[i] )
            {
                answer.push_back(i);
            }
        }
    }
    // 역방향
    else if(k == 0)
    {
        for(int i=n;i>=1;i--)
        {
            if( !visited[i] )
            {
                answer.push_back(i);
            }
        }
    }

    return answer;
}