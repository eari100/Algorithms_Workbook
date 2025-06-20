#include<iostream>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/26070 (곰곰이와 학식)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.06.20 (O)
 **/
long long full = 0;

void use_coupon(int& food, int& coupon)
{
  int _min = min(food, coupon);
  food -= _min;
  coupon -= _min;
  full += _min;
}

void convert_coupon(int& coupon1, int& coupon2)
{
  coupon2 += coupon1 / 3;
  coupon1 %= 3;
}

int main()
{
  int foods[3], coupons[3];
  cin >> foods[0] >> foods[1] >> foods[2] >> coupons[0] >> coupons[1] >> coupons[2];

  for(int i=0;i<6;i++)
  {
    use_coupon(foods[i % 3], coupons[i % 3]);
    convert_coupon(coupons[i % 3], coupons[(i+1) % 3]);
  }

  cout << full;
}