#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/7490 (0 만들기)
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 25.11.23 (O)
 **/
int t, target;
char cal[10];

void bt(int depth)
{
    if (depth > target)
    {
        int result = 0;

        char temp_c = '+';
        int temp_i = 1;
        string s = "1";

        for (int i=2;i<=target;i++)
        {
            s += cal[i];
            s += (char)('0' + i);

            if (cal[i] == '+' || cal[i] == '-')
            {
                if (temp_c == '+')
                {
                    result += temp_i;
                }
                else if (temp_c == '-')
                {
                    result -= temp_i;
                }

                temp_i = i;
                temp_c = cal[i];
            }
            else
            {
                temp_i *= 10;
                temp_i += i;
            }
        }

        if (temp_c == '+')
        {
            result += temp_i;
        }
        else if (temp_c == '-')
        {
            result -= temp_i;
        }

        if (result == 0)
        {
            cout << s << '\n';
        }

        return;
    }

    cal[depth] = ' ';
    bt(depth+1);

    cal[depth] = '+';
    bt(depth+1);

    cal[depth] = '-';
    bt(depth+1);

}

int main()
{
    cal[1] = '+';
    while (t--)
    {
        cin>>target;
        bt(2);
        cout << '\n';
    }
}