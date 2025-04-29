#include<iostream>
#include<unordered_map>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1270 (전쟁 - 땅따먹기)
 * @classification: hash
 * @문제 푼 날짜 (자력으로 풂?): 25.04.29 (O)
 **/
int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  int t;
  cin >> t;

  while(t--)
  {
    int cnt;
    cin>>cnt;

    unordered_map<long long, int> m;
    int max_val = 0;
    long long max_key = 0;

    for(int i=0;i<cnt;i++)
    {
      long long key;
      cin >> key;

      m[key]++;

      if(max_val < m[key])
      {
        max_val = m[key];
        max_key = key;
      }
    }

    if(max_val > cnt / 2)
    {
      cout << max_key << '\n';
    }
    else
    {
      cout << "SYJKGW" << '\n';
    }
  }
}