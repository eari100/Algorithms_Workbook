#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/30457 (단체줄넘기)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.09.05 (O)
 **/
int main()
{
    int n;
    cin>>n;
    vector<int> r, l, total(n);
    r.push_back(0);
    l.push_back(0);

    for(int i=0;i<n;i++)
    {
        cin>>total[i];
    }

    sort(total.begin(),total.end());

    for(int i=0;i<n;i++)
    {
        if (l[l.size()-1] < total[i])
        {
            l.push_back(total[i]);
        }
        else if (r[r.size()-1] < total[i])
        {
            r.push_back(total[i]);
        }

    }

    cout << l.size() + r.size() - 2;
}