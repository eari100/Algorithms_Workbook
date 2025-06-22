#include<iostream>
#include<queue>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/13975 (파일 합치기 3)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.06.22 (O)
 **/
int main()
{
  int t, k;

  cin>> t;

  while(t--)
  {
    long long answer = 0;
    priority_queue<long long, vector<long long>, greater<int>> files;
    cin>>k;
    for(int i=0;i<k;i++)
    {
      int x;
      cin>>x;
      files.push(x);
    }

    while(files.size() > 1)
    {
      long long a = files.top();
      files.pop();
      long long b = files.top();
      files.pop();

      long long sum = a + b;
      answer += sum;

      files.push(sum);
    }

    cout << answer << '\n';
  }
}