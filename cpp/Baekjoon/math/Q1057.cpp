#include <iostream>
#include <cmath>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1057 (토너먼트)
 * @classification: math
 * @문제 푼 날짜 (자력으로 풂?): 25.10.01 (O)
 **/
int n, a, b;

int main()
{
    cin>>n>>a>>b;

    int p = 1;
    bool flag = false;

    while (1)
    {
        int range = pow(2, p);

        for (int i=1;i<=n;i+=range)
        {
            if (i <= a && a <= i+range-1 && i <= b && b <= i+range-1)
            {
                cout << p;
                flag = true;
                break;
            }
        }

        if (flag)
        {
            break;
        }

        ++p;
    }
}