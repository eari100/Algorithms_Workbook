#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/4921 (나무 블록)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.06.26 (O)
 **/
int order = 0;

void fail()
{
  cout << order << ". NOT" << '\n';
}

void success()
{
  cout << order << ". VALID" << '\n';
}

int main()
{
  string nums;

  while(1)
  {
    cin >> nums;
    if(nums == "0") break;
    order++;

    if(nums[0] != '1' || nums[nums.length()-1] != '2')
    {
      fail();
      continue;
    }

    bool valid = true;

    for(int i=1;i<nums.length();i++)
    {
      if(nums[i-1] == '1' && ( nums[i] == '4' || nums[i] == '5' ))
      {
        continue;
      }

      if(nums[i-1] == '3' && ( nums[i] == '4' || nums[i] == '5' ))
      {
        continue;
      }

      if(nums[i-1] == '4' && (nums[i] == '2' || nums[i] == '3' ))
      {
        continue;
      }

      if(nums[i-1] == '5' && nums[i] == '8')
      {
        continue;
      }

      if(nums[i-1] == '6' && ( nums[i] == '2' || nums[i] == '3'))
      {
        continue;
      }

      if(nums[i-1] == '7' && nums[i] == '8')
      {
        continue;
      }

      if(nums[i-1] == '8' && ( nums[i] == '6' || nums[i] == '7'))
      {
        continue;
      }

      valid = false;
      break;
    }

    valid ? success() : fail();
  }
}