#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/12755 (수면 장애)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.05.07 (O)
 **/

int main()
{
  int n, num = 1, len = 0;
  char answer;
  cin>>n;

  while (len < n)
  {
    string num_str = to_string(num++);

    for (int i=0;i<num_str.size();i++)
    {
      ++len;
      answer = num_str[i];

      if (len == n) break;
    }
  }

  cout << answer;
}