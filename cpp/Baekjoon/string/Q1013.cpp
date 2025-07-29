#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1013 (Contact)
 * @classification: string
 * @문제 푼 날짜 (자력으로 풂?): 25.07.29 (O)
 **/
int t, index, one_cnt, zero_cnt;
bool pass;
string s;

bool check_index()
{
  if(index == 0)
  {
    return pass = false;
  }
  index--;

  return true;
}

bool check_type2()
{
  while(index >= 0 && s[index] == '0')
  {
    zero_cnt++;
    index--;
  }

  if(zero_cnt < 2)
  {
    pass = false;
    return false;
  }

  if(index < 0 || s[index] != '1')
  {
    pass = false;
    return false;
  }

  // s[index] == '1' 는 말이됨
  --index; // 다음 루프를 위한

  return true;
}

int main()
{

  cin>>t;

  while(t--)
  {
    cin>>s;
    index = s.size() - 1;
    one_cnt = 0;
    zero_cnt = 0;
    pass=true;

    // print
    //cout << "=======" << endl;

    while(index >= 0)
    {
      // print
      //cout << index << endl;

      if(s[index] == '0')
      {
        pass = false;
        break;
      }

      if( !check_index() ) break;
      if(s[index] == '0') // type 미확정 01
      {
        if(index == 0) break;
        --index;

        if(s[index] == '0') // type 2 확정 001
        {
          zero_cnt++;
          if(!check_type2()) break;
        }
//        else // type 1 확정
//        {}
      }
      else // type 2 확정 11
      {
        // 1제거
        while(index >= 0 && s[index] == '1')
        {
          index--;
        }
        if(!check_type2()) break;
      }
    }

    cout << (pass ? "YES" : "NO") << '\n';
  }
}