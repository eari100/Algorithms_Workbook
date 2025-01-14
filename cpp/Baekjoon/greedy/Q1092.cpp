#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1092 (배)
 * @classification: greedy, sort
 * @문제 푼 날짜 (자력으로 풂?): 25.01.14 (X)
 **/
int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  int craneCnt, boxCnt, time = 0;
  cin >> craneCnt;
  int cranes[craneCnt];

  for (int i = 0; i < craneCnt; i++) {
    cin >> cranes[i];
  }
  sort(cranes, cranes + craneCnt, greater<int>());

  vector<int> boxes;

  cin >> boxCnt;

  int boxWeight;
  for (int i = 0; i < boxCnt; i++) {
    cin >> boxWeight;
    boxes.push_back(boxWeight);
  }

  sort(boxes.begin(), boxes.end(), greater<int>());

  if (boxes[0] > cranes[0]) {
    time = -1;
  } else {
    while ( !boxes.empty() ) {
      ++time;

      for (int i=0; i < craneCnt; i++) {
        for (int j=0; j < boxes.size(); j++) {
          if (boxes[j] <= cranes[i]) {
            boxes.erase(boxes.begin() + j);
            break;
          }
        }
      }
    }
  }

  cout << time;
}