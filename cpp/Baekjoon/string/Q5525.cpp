#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/5525 (IOIOI)
 * @classification: string
 * @문제 푼 날짜 (자력으로 풂?): 25.07.28 (O)
 **/
int main()
{
  long long y, len, x = 0, answer = 0;
  string s;
  cin>>y>>len>>s;

  for(int i = 0; i < len; i++)
  {
    if(x==0 && s[i] == 'I')
    {
      i+=2;
      x++;
      while(true)
      {
        if (i >= len)
        {
          i-=2;
          break;
        }

        if(s[i-1] == 'O' && s[i] == 'I')
        {
          i+=2;
          x++;
        }
        else
        {
          i-=2;
          break;
        }
      }

      if (x > y)
        answer += (x - y);
      x = 0;
    }
  }

  cout<<answer;
}