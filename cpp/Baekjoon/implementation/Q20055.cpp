#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/20055 (컨베이어 벨트 위의 로봇)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.09.24 (O)
 **/
int n, k, tmp, round = 1;
vector<int> container;
vector<bool> robot_dir;

int main()
{
  cin>>n>>k;
  for(int i=0;i<n*2;i++)
  {
    cin>>tmp;
    container.push_back(tmp);
  }

  robot_dir.resize(n, false);

  while(1)
  {
    bool lp1 = true;
    // 컨테이너 회전
    int last = container.back();
    container.pop_back();
    container.insert(container.begin(), last);
    for(int i=robot_dir.size()-2;i>=0;i--)
    {
      robot_dir[i+1] = robot_dir[i];
    }
    // 올라오는 컨테이너에 의해 비워짐
    robot_dir[0] = false;
    // 로봇 탈출
    robot_dir[n-1] = false;

    // 로봇 이동
    for(int i=robot_dir.size()-2;i>0;i--)
    {
      bool curr = robot_dir[i];
      bool next = robot_dir[i+1];

      // 이동 가능
      if(!next && curr && container[i+1])
      {
        robot_dir[i] = false;
        robot_dir[i+1] = true;
        container[i+1]--;

        // 컨테이너 0으로 소진
        if( !container[i+1] )
        {
          --k;
          if(k == 0)
          {
            lp1 = false;
            break;
          }
        }
      }
    }

    if (!lp1)
    {
      break;
    }

    // 로봇 입장
    if(container[0])
    {
      robot_dir[0] = true;
      container[0]--;

      if(!container[0])
      {
        --k;
        if(k == 0)
        {
          break;
        }
      }
    }

    // cout << round << ": " << k << endl;
    // for (int i=0;i<container.size();i++)
    // {
    //   cout<<container[i]<<" ";
    // }
    // cout <<endl;
    //
    // for (int i=0;i<robot_dir.size();i++)
    // {
    //   cout<<robot_dir[i]<<" ";
    // }
    // cout << endl;

    ++round;
  }

  cout<<round;
}