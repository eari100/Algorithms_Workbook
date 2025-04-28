#include<iostream>
#include<algorithm>
#include<array>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/3758 (KCPC)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.04.29 (O)
 **/
bool compare(const array<int, 4> &a, const array<int, 4> &b)
{
  if (a[0] != b[0]) return a[0] > b[0]; // 점수 내림차순
  if (a[1] != b[1]) return a[1] < b[1]; // 제출횟수 오름차순
  return a[2] < b[2]; // 마지막 제출 빠른 순
}

int main()
{
  int t, tcnt, pcnt, my_id, logcnt, id, qid, score;

  cin >> t;

  while(t--)
  {
    cin >> tcnt >> pcnt >> my_id >> logcnt;
    int board[tcnt][pcnt];
    array<int, 4> board2[tcnt];

    for(int i=0;i<tcnt;i++)
    {
      for(int j=0;j<pcnt;j++)
      {
        board[i][j] = 0;
      }
      for(int j=0;j<3;j++)
      {
        board2[i][j] = 0;
      }
      board2[i][3] = i;
    }

    for(int i=0;i<logcnt;i++)
    {
      cin >> id >> qid >> score;

      if(board[id-1][qid-1] < score)
      {
        board2[id-1][0] += score - board[id-1][qid-1];
        board[id-1][qid-1] = score;
      }

      board2[id-1][1]++; // 제출횟수
      board2[id-1][2] = i; // 마지막 제출
    }

    sort(board2, board2 + tcnt, compare);

    for (int i=0;i<tcnt;i++)
    {
      if (board2[i][3] == my_id-1)
      {
        cout << (i+1) << '\n';
        break;
      }
    }
  }
}