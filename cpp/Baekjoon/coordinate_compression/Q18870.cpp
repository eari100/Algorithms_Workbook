#include<iostream>
#include<algorithm>
#include<set>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/18870 (좌표 압축)
 * @classification: coordinate compression
 * @문제 푼 날짜 (자력으로 풂?): 25.04.12 (O)
 **/
int main()
{
  int n, num;
  cin>>n;
  set<int> set;
  int nums[n];

  for(int i=0;i<n;i++)
  {
    cin>>num;
    set.insert(num);
    nums[i] = num;
  }

  int sorted_nums[set.size()];
  copy(set.begin(), set.end(), sorted_nums);
  sort(sorted_nums, sorted_nums+set.size());

  for(int _num : nums)
  {
    int str = 0, end = set.size()-1;

    while(str <= end)
    {
      int mid = str + (end - str) / 2;

      if (sorted_nums[mid] == _num)
      {
        cout<<mid<<' ';
        break;
      }

      if(sorted_nums[mid] > _num)
      {
        end = mid - 1;
      } else {
        str = mid + 1;
      }
    }
  }
}