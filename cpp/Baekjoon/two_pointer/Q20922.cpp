#include <iostream>
#include <map>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/20922 (겹치는 건 싫어)
 * @classification: two-pointer
 * @문제 푼 날짜 (자력으로 풂?): 25.07.31 (O)
 **/
int main()
{
  int n, k, str = 0, end = 1, max_len = 1;
  map<int, int> chk;

  cin>>n>>k;
  int nums[n];

  for(int i=0;i<n;i++)
  {
    cin>>nums[i];
  }

  chk[nums[0]]++;
  while (str <= end && end < n)
  {
    if (chk[nums[end]] == k)
    {
      chk[nums[str]]--;
      str++;
    }
    else
    {
      max_len = max(max_len, end - str + 1);
      chk[nums[end]]++;
      ++end;
    }
  }

  cout << max_len;
}