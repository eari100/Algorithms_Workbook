#include <iostream>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2776 (암기왕)
 * @classification: binary search
 * @문제 푼 날짜 (자력으로 풂?): 25.01.09 (O)
 **/
bool binary_search(int nums[], int n, int target) {
  int str = 0, end = n - 1;

  if (target < nums[str] || target > nums[end]) {
    return false;
  }

  while (str <= end) {
    int mid = (str + end) / 2;

    if (nums[mid] == target) {
      return true;
    } else if (nums[mid] < target) {
      str = mid + 1;
    } else {
      end = mid - 1;
    }
  }

  return false;
}

int main() {
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  int t;
  cin >> t;

  for(int i=0;i<t;i++){
    int n, m, num, target;
    cin >> n;
    int nums[n];

    for(int j=0;j<n;j++){
      cin >> num;
      nums[j] = num;
    }

    sort(nums, nums+n);

    cin >> m;
    for(int j=0;j<m;j++) {
      cin >> target;
      cout << (int) binary_search(nums, n, target) << '\n';
    }
  }
}