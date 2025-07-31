  #include <iostream>

  using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/17358 (복불복으로 지구 멸망)
 * @classification: combinatorics
 * @문제 푼 날짜 (자력으로 풂?): 25.08.01 (O)
 **/
  int main()
  {
    int n;
    cin>>n;
    long long answer = 1;

    for(int i = 2; i <= n; i+=2)
    {
      answer = answer * (i - 1) % 1'000'000'007;
    }

    cout << answer;
  }