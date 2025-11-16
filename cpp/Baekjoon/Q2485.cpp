#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/17198 (가로수)
 * @classification: math
 * @문제 푼 날짜 (자력으로 풂?): 25.11.16 (O)
 **/
int n, trees[100'000+1], dist[100'000+1], _min = (1<<31)-1;

int main()
{
    cin>>n;

    for(int i=0;i<n;i++)
    {
        cin>>trees[i];

        if (i > 0)
        {
            dist[i] = trees[i] - trees[i-1];
            _min = min(_min, dist[i]);
        }
    }

    for (int i=_min;i>=0;i--)
    {
        bool match = true;
        int append_tree = 0;
        for (int j=1;j<n;j++)
        {
            if (dist[j] % i != 0)
            {
                match = false;
                break;
            }

            append_tree += (dist[j] / i)-1;
        }

        if (match)
        {
            cout << append_tree ;
            return 0;
        }
    }
}