#include<iostream>
#include<set>
#include<cmath>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/13908 (비밀번호)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.05.28 (O)
 **/
int main()
{
  int len, cnt, answer = 0;
  set<int> nums;

  cin>>len>>cnt;

  for(int i=0;i<cnt;i++)
  {
    int num;
    cin>>num;
    nums.insert(num);
  }

  for(int i=0;i<pow(10, len);i++)
  {
    int curr = i, correct = 0;
    bool check[10] = {false};

    for (set<int>::iterator it = nums.begin();it!=nums.end();++it)
    {
      check[*it] = true;
    }

    for(int j=0;j<len;j++)
    {
      if(check[curr % 10])
      {
        correct++;
        check[curr % 10] = false;
      }
      curr /= 10;
    }

    if (correct == nums.size())
    {
      ++answer;
    }
  }

  cout << answer;
}