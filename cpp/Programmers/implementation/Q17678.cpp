#include <string>
#include <vector>
#include <queue>

using namespace std;

/**
* @source: https://school.programmers.co.kr/learn/courses/30/lessons/17678 (2018 KAKAO BLIND RECRUITMENT > [1차] 셔틀버스)
* @classification: implementation
* @문제 푼 날짜 (자력으로 풂?): 25.11.28(O)
**/
struct comp {
    bool operator()(int a, int b) {
        return a > b;
    }
};

priority_queue<int, vector<int>, comp> persons;
vector<int> bus;
int bus_time = 9 * 60;
vector<vector<int>> bus_persons;
int bp_i = 0, bp_j = 0;

string solution(int n, int t, int m, vector<string> timetable) {
    int corn_time = 0;
    bus_persons.resize(n);

    for(string t : timetable) {
        int time = ((int)(t[0]-'0')) * 10 + ((int)(t[1]-'0'));
        int minute = ((int)(t[3]-'0')) * 10 + ((int)(t[4]-'0'));
        persons.push(time*60+minute);
    }

    while(persons.size()) {
        if(bp_j == m) { // 다음 버스로 이동
            bp_i++;
            bp_j = 0;
            bus_time += t;
        }

        if(bp_i == n) { // 모든 버스 꽉참
            break;
        }

        int f = persons.top();

        if(f > bus_time) { // 다음 버스 포인팅
            bp_i++;
            bp_j = 0;
            bus_time += t;
        } else { // 버스에 태움
            bp_j++;
            bus_persons[bp_i].push_back(f);
            persons.pop();
        }
    }

    for(int i=0;i<n;i++) {
        int cnt = bus_persons[i].size();
        int bt = 9 * 60 + (i * t);

        if(cnt == m) {
            corn_time = bus_persons[i][m-1] - 1;
        } else {
            corn_time = bt;
        }
    }

    if(corn_time == 0) {
        return "00:00";
    } else {
        string answer = "";

        int share = corn_time / 60;
        int remain = corn_time % 60;

        if(share < 10) {
            answer += '0';
            answer += (char)(share + (int)'0');
        } else {
            int share_h = share / 10;
            int share_m = share % 10;

            answer += ((char)(share_h + (int)'0'));
            answer += ((char)(share_m + (int)'0'));
        }

        answer += ':';

        if(remain < 10) {
            answer += '0';
            answer += (char)(remain + (int)'0');
        } else {
            int remain_h = remain / 10;
            int remain_m = remain % 10;

            answer += (remain_h + (int)'0');
            answer += (char)(remain_m + (int)'0');
        }

        return answer;
    }
}