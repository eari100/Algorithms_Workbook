#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/12933 (오리)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.09.20 (O)
 **/
string sound;
bool checked[2500];
char duck[5] = {'q', 'u', 'a', 'c', 'k'};
int duck_cnt = 0, duck_index, _remove = 0;

int main()
{
  cin>>sound;

  if(sound[0] != duck[0] || sound.size() % 5 != 0)
  {
    cout<<-1;

    return 0;
  }

  while(_remove < sound.size())
  {
    duck_index = 0;
    for(int i=0;i<sound.size();i++)
    {
      if(checked[i]) continue;

      if(sound[i] == duck[duck_index])
      {
        checked[i] = 1;
        duck_index = (duck_index + 1) % 5;
        _remove++;

        if(duck_index == 5)
        {
          duck_index = 0;
        }
      }
    }

    if(duck_index != 0)
    {
      cout << -1;

      return 0;
    }

    duck_cnt++;
  }

  cout << duck_cnt;
}