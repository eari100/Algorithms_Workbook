#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/17124 (두 개의 배열)
 * @classification: two-pointer
 * @문제 푼 날짜 (자력으로 풂?): 26.01.28 (O)
 **/
long long t,n,m,sum,idx;

int main()
{
    cin>>t;

    while(t--)
    {
        sum=0;
        idx=0;
        cin>>n>>m;

        vector<int> a(n),b(m);

        for(int i=0;i<n;i++)
        {
            cin>>a[i];
        }

        for(int i=0;i<m;i++)
        {
            cin>>b[i];
        }

        sort(a.begin(), a.end());
        sort(b.begin(), b.end());

        for(int i=0;i<n;i++)
        {
            int min_abs = (1ULL << 31) - 1;
            idx--;
            while(idx+1<m)
            {
                int _abs = abs(a[i] - b[idx+1]);

                if(_abs >= min_abs)
                {
                    break;
                }

                idx++;
                min_abs = _abs;
            }
            sum+=b[idx];
        }

        cout<<sum<<'\n';
    }
}