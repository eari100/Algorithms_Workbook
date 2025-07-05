#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/17251 (힘 겨루기)
 * @classification: adhoc
 * @문제 푼 날짜 (자력으로 풂?): 25.07.05 (O)
 **/
int main()
{
  int n, red, blue, x, _max = 0, idx1, idx2;
  cin >> n;

  for(int i=0;i<n;i++)
  {
    cin >> x;
    if (_max == x)
    {
      idx2 = i;
    }
    else if (_max < x)
    {
      _max = x;
      idx1 = i;
      idx2 = i;
    }
  }

  red = idx1;
  blue = n - 1 - idx2;

  if(red == blue)
  {
    cout << 'X';
  }
  else if(red < blue)
  {
    cout << "R";
  }
  else
  {
    cout << "B";
  }
}