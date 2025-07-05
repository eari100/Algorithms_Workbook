#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/33643 (Keys, Phone, Wallet)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.07.05 (O)
 **/
int main()
{
  int n, match = 0;
  string obj;
  bool checked[3] = {false, false, false};
  string items[3] = {"keys", "phone", "wallet"};

  cin >> n;

  while(n--)
  {
    cin >> obj;

    for(int i = 0; i < 3; i++)
    {
      if(obj == items[i] && !checked[i])
      {
        match++;
        checked[i] = true;
        break;
      }
    }
  }

  if(match == 3)
  {
    cout << "ready";
  }
  else
  {
    for(int i=0;i<3;i++)
    {
      if(!checked[i])
      {
        cout << items[i] << '\n';
      }
    }
  }
}