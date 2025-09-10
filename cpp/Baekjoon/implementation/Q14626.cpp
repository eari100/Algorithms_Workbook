#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14626 (ISBN)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.09.10 (O)
 **/
int main()
{
    string isbn;
    cin>>isbn;
    int sum = 0, MOD = 10;
    bool three = false;

    for (int i=0;i<isbn.length();i++)
    {
        if(isbn[i] == '*')
        {
            if (i % 2 != 0)
            {
                three = true;
            }

            continue;
        }

        int x = isbn[i] - '0';

        if (i % 2 != 0)
        {
            x *= 3;
        }

        sum += x;
    }

    for (int i=0;i<=9;i++)
    {
        if (three)
        {
            sum += (i * 3);
        }
        else
        {
            sum += i;
        }

        if ( (sum % MOD) == 0)
        {
            cout << i;
            break;
        }

        if (three)
        {
            sum -= (i * 3);
        }
        else
        {
            sum -= i;
        }
    }
}