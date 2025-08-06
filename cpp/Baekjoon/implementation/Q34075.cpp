#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/34075 (세그먼트 트리보다도 바･로･너･♡)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.08.05 (O)
 **/
struct algo
{
  string name;
  int difficulty;
};

struct compare_algo
{
  bool operator() (const algo& a, const algo& b) const
  {
    if(a.difficulty != b.difficulty)
    {
      return a.difficulty > b.difficulty;
    }

    return a.name > b.name;
  }
};

int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  int n, m, k, i_tmp;
  string s_tmp, hai = "hai!", selected_member, yori_mo = " yori mo ";
  cin>>n;
  vector<algo> algorithms;
  unordered_map<string, int> members;
  unordered_map<string, string> answer_cash;

  for(int i=0;i<n;i++)
  {
    cin>>s_tmp;
    cin>>i_tmp;
    algorithms.push_back({s_tmp, i_tmp});
  }

  cin>>m;
  for(int i=0;i<m;i++)
  {
    cin>>s_tmp;
    cin>>members[s_tmp];
  }

  cin>>k;
  for(int i=0;i<k;i++)
  {
    string one, two, three;
    cin>>one >> two >> three;

    if(two != "-")
    {
      auto it_found = answer_cash.find(selected_member);
      if(it_found != answer_cash.end())
      {
        cout << it_found->second << '\n';
        continue;
      }

      priority_queue<algo, vector<algo>, compare_algo> algo_pq;
      int difficulty = members[selected_member];
      string a1, a2;

      for(algo a : algorithms)
      {
        algo_pq.push({a.name, abs(a.difficulty - difficulty)});
      }

      a1 = algo_pq.top().name;
      algo_pq.pop();
      a2 = algo_pq.top().name;

      string result = a2 + yori_mo + a1;
      answer_cash[selected_member] = result;
      cout << result << '\n';
    }
    else
    {
      selected_member = one;
      cout << hai << '\n';
    }
  }
}