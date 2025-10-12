#include<iostream>

using namespace std;

int target, n, num, answer = (1<<31)-1;
bool broken[10];

/**
 * @source: https://www.acmicpc.net/problem/1107 (리모컨)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.10.12 (O)
 **/
int ipc(int c)
{
  if (c == 0)
  {
    if (broken[0])
    {
      return -1;
    }
    else
    {
      return 1;
    }
  }

  int len = 0;
  while (c)
  {
    if (broken[c % 10])
    {
      return -1;
    }
    c /= 10;
    len++;
  }

  return len;
}

int main()
{
  cin>>target>>n;
  for(int i=0;i<n;i++)
  {
    cin>>num;
    broken[num]=true;
  }

  answer = min(answer, abs(target - 100));

  int minus = target, plus = target;

  while (minus >= 0 && answer > target-minus)
  {
    int len = ipc(minus);
    if (len != -1)
    {
      answer = min(answer, target-minus+len);
    }

    minus--;
  }

  while (answer > plus - target)
  {
    int len = ipc(plus);
    if (len != -1)
    {
      answer = min(answer, plus-target+len);
    }

    plus++;
  }

  cout<<answer;
}