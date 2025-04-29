#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2304 (창고 다각형)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.04.29 (O)
 **/
int main()
{
  int walls[1000+1] = {0};
  int n;
  cin>>n;
  int _max = 0;
  int str_index = 0, end_index = 0;

  while(n--)
  {
    int d, h;
    cin>>d>>h;

    walls[d] = h;

    if(h > _max)
    {
      _max = h;
    }

    if(end_index < d)
    {
      end_index = d;
    }
  }

  int answer = 0;
  int curr_h = 0;
  int count = 1;

  for(int i=0;i<=end_index;i++)
  {
    if(curr_h < walls[i])
    {
      answer += curr_h * count;

      curr_h = walls[i];
      count = 1;

      if (walls[i] == _max)
      {
        str_index = i;
        break;
      }
    }
    else
    {
      count++;
    }
  }

  int curr_h2 = 0;
  int count2 = 1;
  int finish_index = 0;

  for(int i=end_index+1;i>=0;i--)
  {
    if(curr_h2 < walls[i])
    {
      answer += curr_h2 * count2;

      curr_h2 = walls[i];
      count2 = 1;

      if(_max == walls[i])
      {
        finish_index = i;
        break;
      }
    }
    else
    {
      count2++;
    }
  }

  answer += (finish_index - str_index + 1) * _max;

  cout<<answer<<endl;
}
