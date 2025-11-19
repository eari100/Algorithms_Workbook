#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1253 (좋다)
 * @classification: two-pointer
 * @문제 푼 날짜 (자력으로 풂?): 25.11.19 (O)
 **/
int n, answer = 0;

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n;
    vector<int> v(n);

    for(int i=0;i<n;i++)
    {
        cin>>v[i];
    }

    sort(v.begin(),v.end());

    for (int i=0;i<n;i++)
    {
        int l = 0, r = n-1;

        if (i == 0)
        {
            l = 1;
        }
        else if (i == n-1)
        {
            r = n-2;
        }

        while (l<r)
        {
            int sum = v[l] + v[r];

            if (sum == v[i])
            {
                ++answer;
                break;
            }

            if (sum < v[i])
            {
                l++;

                if (l == i)
                {
                    l++;
                }
            }
            else
            {
                r--;

                if (r == i)
                {
                    r--;
                }
            }
        }
    }

    cout<<answer;
}