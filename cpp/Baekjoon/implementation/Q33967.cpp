#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/33967 (SCSC 기차 놀이)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.07.09 (O)
 **/
int main()
{
  int n, answer = 0;
  string s;
  cin >> n;
  cin >> s;

  for(int i=0;i<n-1;i++)
  {
    int a = s[i];
    int b = s[i+1];

    if( (a == '5' && b == '5') || (a == '2' && b == '2') )
    {
      answer += 2;
    }
    else if( !(a == ']' && b == '[') )
    {
      answer++;
    }
  }

  cout << answer;
}