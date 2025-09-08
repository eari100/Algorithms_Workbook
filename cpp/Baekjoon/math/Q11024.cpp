#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11024 (더하기 4)
 * @classification: math
 * @문제 푼 날짜 (자력으로 풂?): 25.09.08 (O)
 **/
long long n, sum, index;
string s;

int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  cin>>n;
  getline(cin,s);

  for(int i=0;i<n;i++)
  {
    sum = 0, index = 0;
    int num = 0;
    getline(cin,s);
    string temp = "";

    while(index < s.length())
    {
      if(s[index] != ' ')
      {
        temp += s[index];
      }
      else
      {
        num = 0;
        for(int j=0;j<temp.length();j++)
        {
          num*=10;
          num+=temp[j]-'0';
        }

        sum+=num;
        temp = "";
      }

      index++;
    }

    num = 0;

    for(int j=0;j<temp.length();j++)
    {
      num*=10;
      num+=temp[j]-'0';
    }

    cout << sum+num << '\n';
  }
}