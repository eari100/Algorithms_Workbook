#include<iostream>

/**
 * @source: https://www.acmicpc.net/problem/1091 (카드 섞기)
 * @classification: math, implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.10.30 (지문도 난해 && 수학적 직관이 필요, X)
 **/
#define MAX 48

using namespace std;

int n, shuffle[MAX], init_cards[MAX], cards[MAX], temp_cards[MAX], repeat = 0;
bool match = false;

int main()
{
    cin>>n;

    for (int i=0;i<n;i++)
    {
        cin>>init_cards[i];
        cards[i] = init_cards[i];
    }

    for (int i=0;i<n;i++)
    {
        cin>>shuffle[i];
    }

    while (1)
    {
        // valid
        for (int i=0;i<n;i++)
        {
            if (cards[i] != i % 3)
            {
                break;
            }

            if (i == n-1)
            {
                match = true;
            }
        }

        if (match)
        {
            break;
        }

        // mix
        for (int i=0;i<n;i++)
        {
            temp_cards[shuffle[i]] = cards[i];
        }

        for (int i=0;i<n;i++)
        {
            cards[i] = temp_cards[i];
        }

        bool init_match = true;
        for (int i=0;i<n;i++)
        {
            if (cards[i] != init_cards[i])
            {
                init_match = false;
                break;
            }
        }

        if (init_match)
        {
            break;
        }

        ++repeat;
    }

    cout << (match ? repeat : -1);
}