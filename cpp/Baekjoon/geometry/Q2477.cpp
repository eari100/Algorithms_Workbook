#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2477 (참외밭)
 * @classification: geometry
 * @문제 푼 날짜 (자력으로 풂?): 25.05.02 (O)
 **/
int main()
{
  int size;
  cin>>size;
 // 12, 34
  int max_x = 0, max_y = 0;

  vector<vector<int>> vec;
  for(int i=0;i<6;i++)
  {
    int d, len;
    cin >> d >> len;

    vector<int> vec2 = {d, len};
    vec.push_back(vec2);

    if(d == 1 || d == 2)
    {
      max_x = max(max_x, len);
    }
    else
    {
      max_y = max(max_y, len);
    }
  }

  int answer = max_x * max_y;

  for(int i=0;i<7;i++)
  {
    if(vec[i][0] == vec[(i+2) % 6][0] && vec[(i+1) % 6][0] == vec[(i+3) % 6][0])
    {
      answer -= vec[(i+1) % 6][1] * vec[(i+2) % 6][1];
      break;
    }
  }

  cout << (answer * size);
}