#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/17686 (2018 KAKAO BLIND RECRUITMENT > [3차] 파일명 정렬)
 * @classification: sort
 * @문제 푼 날짜 (자력으로 풂?): 25.11.30 (O)
 **/
bool is_num(char c) {
    return c >= '0' && c <= '9';
}

bool is_lower_case(char c) {
    return c >= 'a' && c <= 'z';
}

char char_toggle(char c) {
    return c ^ 0x20;
}

string get_title(string& s, int& index) {
    string title = "";
    
    for(int i=index;i<s.size();i++) {
        if(is_num(s[index])) {
            break;
        }
        
        if(is_lower_case(s[index])) {
            title += char_toggle(s[index]);
        } else {
            title += s[index];
        }
            
        index++;
    }
    
    return title;
}

int get_number(string& s, int& index) {
    int number = 0;
    int len = min((int)s.size(), index+5);
    
    for(int i=index;i<len;i++) {
        if( !is_num(s[i]) ) {
            break;
        }
        
        number *= 10;
        number += (s[i] - '0');
    }
    
    return number;
}

struct item {
    string s;
    int index;
};

struct comp {
    bool operator()(item a, item b) {
        int index1 = 0, index2 = 0; 
        string h1 = get_title(a.s, index1), h2 = get_title(b.s, index2);

        if(h1 != h2) {
            return h1 < h2;    
        }
        
        int n1 = get_number(a.s, index1), n2 = get_number(b.s, index2);

        if(n1 != n2) {
            return n1 < n2;
        }
        return a.index < b.index;
    }
};

vector<item> v;
vector<string> answer;

vector<string> solution(vector<string> files) {
    for(int i=0;i<files.size();i++) {
        v.push_back({files[i], i});
    }
    
    sort(v.begin(), v.end(), comp());
    
    for(item it : v) {
        answer.push_back(it.s);
    }
    
    return answer;
}