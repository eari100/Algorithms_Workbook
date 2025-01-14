#include <iostream>
#include <algorithm>
using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1106 (호텔)
 * @classification: knapsack, dp
 * @문제 푼 날짜 (자력으로 풂?): 25.01.14 (X)
 **/
int main() {
  int INF = 1e7;
  int targetValue, cityCount;
  cin >> targetValue >> cityCount;
  // value, cost
  int memo[targetValue+1];
  // cost, value
  int cities[cityCount][2];

  for(int i=0;i<targetValue+1;i++) {
    memo[i] = INF;
  }
  memo[0] = 0;

  for(int i=0;i<cityCount;i++) {
    cin >> cities[i][0] >> cities[i][1];
  }

  for (int (&city)[2] : cities) {
    int cost = city[0], value = city[1];

    for (int currValue = 0; currValue <= targetValue; currValue++) {
      int nextValue = min(targetValue, currValue + value);
      if (memo[currValue] + cost < memo[nextValue]) {
        memo[nextValue] = memo[currValue] + cost;
      }
    }
  }

  cout << memo[targetValue];
}
