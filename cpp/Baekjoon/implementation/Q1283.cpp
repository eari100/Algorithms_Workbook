#include <iostream>
#include <string>

using namespace std;

char to_lower_case(char& c)
{
  if(c >= 'A' && c <= 'Z')
    return c ^ 0x20;
  return c;
}

/**
 * @source: https://www.acmicpc.net/problem/1283 (단축키 지정)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.06.01 (O)
 **/
int main()
{
  int t;
  cin >> t;
  cin >> ws;
  bool checked[26];

  for(int i = 0; i < 26; i++)
  {
    checked[i] = false;
  }

  while (t--)
  {
    string str, answer = "";
    int index = -1;
    getline(cin, str);

    if (!checked[to_lower_case(str[0]) - 'a'])
    {
      checked[to_lower_case(str[0]) - 'a'] = true;
      index = 0;
    }
    else
    {
      for (int i=1;i<str.size();i++)
      {
        if (str[i] == ' ')
        {
          i++;
          if ( !checked[to_lower_case(str[i]) - 'a'] )
          {
            checked[to_lower_case(str[i]) - 'a'] = true;
            index = i;
            break;
          }
        }
      }
    }

    if (index != -1)
    {
      for (int i=0;i<str.size();i++)
      {
        if (i == index)
        {
          answer += '[';
          answer += str[i];
          answer += ']';
        }
        else
        {
          answer += str[i];
        }
      }
    }
    else
    {
      bool flag = false;
      for (char& c : str)
      {
        if (!flag && c != ' ' && !checked[to_lower_case(c) - 'a'])
        {
          flag = true;
          checked[to_lower_case(c) - 'a'] = true;
          answer += '[';
          answer += c;
          answer += ']';
        }
        else
        {
          answer += c;
        }
      }
    }

    cout << answer << '\n';
  }
}