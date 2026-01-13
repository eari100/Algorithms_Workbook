#include<iostream>

using namespace std;


/**
 * @source: https://www.acmicpc.net/problem/1082 (방 번호)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 26.01.13 (O)
 **/
int n,m;
int moneys[50];
int answer[50];
int answer_idx = 0;
int first_idx;
int first_money = (1ULL<<31)-1;
int total_idx;
int total_money = (1ULL<<31)-1;

int main()
{
    cin>>n;

    for (int i=0;i<n;i++)
    {
        cin>>moneys[i];

        if (i > 0 && first_money >= moneys[i])
        {
            first_idx = i;
            first_money = moneys[i];
        }

        if (total_money >= moneys[i])
        {
            total_idx = i;
            total_money = moneys[i];
        }
    }

    cin>>m;

    // 0만 될때
    if (first_money > m)
    {
        cout<<0;
        return 0;
    }

    m-=first_money;
    answer[answer_idx++] = first_idx;

    while (m >= total_money)
    {
        m-=total_money;
        answer[answer_idx++] = total_idx;
    }

    for (int i=0;i<answer_idx;i++)
    {
        for (int j=n-1;j>answer[i];j--)
        {
            int m2 = m + moneys[answer[i]];

            if (m2 >= moneys[j])
            {
                answer[i] = j;
                m = m2 - moneys[j];
                break;
            }
        }
    }

    for (int i=0;i<answer_idx;i++)
    {
        cout<<answer[i];
    }
}