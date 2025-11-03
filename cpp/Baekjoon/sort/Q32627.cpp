#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/32627 (문자열 줄이기)
 * @classification: sort
 * @문제 푼 날짜 (자력으로 풂?): 25.11.03 (O)
 **/
struct comp
{
    bool operator()(vector<int> a, vector<int> b)
    {
        if (a[0] == b[0])
        {
            return a[1] < b[1];
        }

        return a[0] < b[0];
    }
};

int n, m;
string str;
vector<vector<int>> v;
bool skip[300'000+1];

int main()
{
    cin>>n>>m>>str;

    for (int i=0;i<n;i++)
    {
        v.push_back({str[i], i});
    }

    sort(v.begin(), v.end(), comp());

    for (int i=0;i<m;i++)
    {
        skip[v[i][1]] = true;
    }

    for (int i=0;i<n;i++)
    {
        if ( !skip[i] )
        {
            cout<<str[i];
        }
    }
}