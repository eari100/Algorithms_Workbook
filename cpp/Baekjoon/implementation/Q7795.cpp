#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/7795 (먹을 것인가 먹힐 것인가)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.05.03 (O)
 **/
int main()
{
  int t;
  cin>>t;
  while(t--)
  {
    int n, m;
    cin>>n>>m;

    vector<int> a;
    vector<int> b;

    for(int i=0;i<n;i++)
    {
      int x;
      cin>>x;
      a.push_back(x);
    }

    for(int i=0;i<m;i++)
    {
      int x;
      cin>>x;
      b.push_back(x);
    }

    sort(b.begin(), b.end());

    int answer = 0;
    for(int i=0;i<n;i++)
    {
      int x = a[i];

      for(int j=0;j<m;j++)
      {
        if(x <= b[j]) break;
        ++answer;
      }
    }

    cout << answer << '\n';
  }
}