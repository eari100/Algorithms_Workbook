#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/24465 (데뷔의 꿈)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.09.07 (O)
 **/
int m, d, _count;
bool stars[12];
vector<int> pass;

int get_birth_day(int m, int d)
{
    return m * 100 + d;
}

int star_index(int birth_day)
{
    if (birth_day >= 120 && birth_day <= 218)
    {
        return 0;
    }
    else if (birth_day >= 219 && birth_day <= 320)
    {
        return 1;
    }
    else if (birth_day >= 321 && birth_day <= 419)
    {
        return 2;
    }
    else if (birth_day >= 420 && birth_day <= 520)
    {
        return 3;
    }
    else if (birth_day >= 521 && birth_day <= 621)
    {
        return 4;
    }
    else if (birth_day >= 622 && birth_day <= 722)
    {
        return 5;
    }
    else if (birth_day >= 723 && birth_day <= 822)
    {
        return 6;
    }
    else if (birth_day >= 823 && birth_day <= 922)
    {
        return 7;
    }
    else if (birth_day >= 923 && birth_day <= 1022)
    {
        return 8;
    }
    else if (birth_day >= 1023 && birth_day <= 1122)
    {
        return 9;
    }
    else if (birth_day >= 1123 && birth_day <= 1221)
    {
        return 10;
    }
    else
    {
        return 11;
    }
}

int main()
{
    for (int i=0;i<7;i++)
    {
        cin>>m>>d;

        int birth_day = get_birth_day(m, d);
        stars[star_index(birth_day)] = true;
    }

    cin>>_count;

    for (int i=0;i<_count;i++)
    {
        cin>>m>>d;

        int birth_day = get_birth_day(m, d);
        if ( !stars[star_index(birth_day)] )
        {
            pass.push_back(birth_day);
        }
    }

    if (pass.size() == 0)
    {
        cout << "ALL FAILED";
    }
    else
    {
        sort(pass.begin(), pass.end());

        for (int p : pass)
        {
            int m = p / 100;
            int d = p % 100;

            cout << m << " " << d << '\n';
        }
    }
}