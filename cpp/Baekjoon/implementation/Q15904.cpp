#include<iostream>

using namespace std;

string UCPC = "UCPC";
int index = 0;

/**
 * @source: https://www.acmicpc.net/problem/15904 (UCPC는 무엇의 약자일까?)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.06.25 (O)
 **/
int main()
{
  string s;
  getline(cin, s);

  for(int i=0;i<s.length();i++)
  {
    if(s[i] == UCPC[index])
    {
      index++;
    }
  }

  cout << (index >= 4 ? "I love UCPC" : "I hate UCPC");
}