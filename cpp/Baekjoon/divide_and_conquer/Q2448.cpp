#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2448 (별 찍기 - 11)
 * @classification: divide and conquer
 * @문제 푼 날짜 (자력으로 풂?): 25.12.06 (O)
 **/
int n;
vector<vector<int>> v;

void solve(int x1, int y1, int x2, int y2)
{
    int height = x2 - x1 + 1;

    if (height == 3)
    {
        int mid = y1+(y2-y1)/2;
        v[x1][mid] = true;
        v[x1+1][mid-1] = true;
        v[x1+1][mid+1] = true;

        for (int i=y1;i<=y2;i++)
        {
            v[x1+2][i] = true;
        }

        return;
    }

    int share = height / 3;
    int half_share = share/2;
    int bottom = (half_share*5) + (half_share-1);

    solve(x1, y1+bottom/2+1, x1+height/2-1, y1+bottom/2+bottom);
    solve(x1+height/2, y1, x2, y1+bottom-1);
    solve(x1+height/2, y1+bottom+1, x2, y2);
}

int main()
{
    cin>>n;

    int share = n/3;
    int bottom = 5*share+(share-1);
    v.resize(n, vector<int>(bottom, 0));

    solve(0, 0, n-1, bottom-1);

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<bottom;j++)
        {
            cout << (v[i][j] ? '*' : ' ');
        }
        cout << '\n';
    }
}