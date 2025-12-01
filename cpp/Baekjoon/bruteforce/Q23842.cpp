#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/23842 (성냥개비)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.12.01 (X)
 **/
int _data[10] =
{
    6, 2, 5, 5, 4,
    5, 6, 3, 7, 6
};

int n;

int main()
{
    cin>>n;
    n-=4;

    for (int i=0;i<=9;i++)
    {
        for (int j=0;j<=9;j++)
        {
            for (int k=0;k<=9;k++)
            {
                for (int l=0;l<=9;l++)
                {
                    int a = i * 10 + j;
                    int b = k * 10 + l;
                    int c = a + b;

                    if (c > 99)
                    {
                        continue;
                    }

                    int a_cnt = _data[i] + _data[j];
                    int b_cnt = _data[k] + _data[l];

                    int c1 = 0, c2 = 0;

                    if (c)
                    {
                        c1 = c / 10;
                        c2 = c % 10;
                    }

                    int c_cnt = _data[c1] + _data[c2];

                    if (a_cnt + b_cnt + c_cnt == n)
                    {
                        cout<<i<<j<<"+"<<k<<l<<"=";

                        if (c < 10)
                        {
                            cout<<'0';
                        }

                        cout<<c;
                        return 0;
                    }
                }
            }
        }
    }

    cout << "impossible";
}