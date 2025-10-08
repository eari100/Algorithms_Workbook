#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1911 (흙길 보수하기)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.10.08 (O)
 **/
int n, l, s, e, answer = 0, my_init = 0;

struct comp
{
    bool operator()(vector<int> a, vector<int> b)
    {
        return a[0] < b[0];
    }
};

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
    cin>>n>>l;

    vector<vector<int>> holes(n);

    for (int i=0;i<n;i++)
    {
        cin>>s>>e;
        holes[i] = {s, e};
    }

    sort(holes.begin(), holes.end(), comp());

    for (int i=0;i<n;i++)
    {
        for (int j=max(holes[i][0], my_init);j<holes[i][1];)
        {
            ++answer;
            j += l;
            my_init = j;
        }
    }

    cout<<answer;
}