#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/9934 (완전 이진 트리)
 * @classification: divide and conquer
 * @문제 푼 날짜 (자력으로 풂?): 26.04.01 (O)
 **/
int k, v_size;
vector<int> v;
vector<vector<int>> t(10);

int get_mid(int l, int r)
{
    return (l+r)>>1;
}

void search(int depth, int l, int r)
{
    if (l==r)
    {
        t[depth].push_back(v[l]);
        return;
    }

    int m = get_mid(l, r);
    search(depth+1, l, m-1);
    t[depth].push_back(v[m]);
    search(depth+1, m+1, r);
}

int main()
{
    cin>>k;
    v_size=pow(2,k)-1;
    v.reserve(v_size);

    for (int i=0;i<v_size;i++)
    {
        cin>>v[i];
    }

    search(0, 0, v_size-1);

    for (int i=0;i<k;i++)
    {
        for (int j=0;j<t[i].size();j++)
        {
            cout<<t[i][j]<<' ';
        }

        cout<<'\n';
    }
}