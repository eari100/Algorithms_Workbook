#include <string>
#include <vector>
#include <set>
#include <iostream>
#include <unordered_map>

using namespace std;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/42893 (2019 KAKAO BLIND RECRUITMENT > 매칭 점수)
 * @classification: string
 * @문제 푼 날짜 (자력으로 풂?): 25.12.17 (O, 시간 너무 많이 씀, 다시는 풀고 싶지 않다)
 **/
int max_idx;
double max_score=-1.0;
unordered_map<string, int> name_idx;
vector<set<string>> external_url;
vector<int> basic;
vector<double> link;
vector<double> total;

string page_name_prefix = "<meta property=\"og:url\" content=\"";
string page_name_suffix = "/>";
string external_url_prefix = "<a href=\"";
string external_url_suffix = ">";

bool conn[20][20];
int pi[12];

bool is_char(char c)
{
    return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
}

bool is_upper(char c)
{
    return c >= 'A' && c <= 'Z';
}

char toggle_case(char c)
{
    return c^0x20;
}

void get_pi(string word)
{
    int str = 0;
    for (int end=1;end<word.size()-1;end++)
    {
        while (str && word[str]!=word[end])
        {
            str = pi[str-1];
        }

        if (word[str] == word[end])
        {
            pi[end] = ++str;
        }
    }
}

void solve(string word, vector<string> pages)
{
    int word_idx = 0;
    for(int i=0;i<pages.size();i++)
    {
        for(int j=0;j<pages[i].size();j++)
        {
            if (pages[i][j]=='<')
            {
                word_idx=0;
                j++;
                if (pages[i][j]=='m')
                {
                    for(int k=1;k<page_name_prefix.size();k++)
                    {
                        if(pages[i][j] != page_name_prefix[k])
                        {
                            break;
                        }

                        j++;

                        if(k==page_name_prefix.size()-1)
                        {
                            string name="";

                            while(j<pages[i].size() && pages[i][j] != '"')
                            {
                                name+=pages[i][j];
                                j++;
                            }

                            // " 로 끝나는가?
                            if(j>=pages[i].size() || pages[i][j] != '"')
                            {
                                break;
                            }

                            j++;
                            // 공백 jump
                            while(j<pages[i].size() && pages[i][j] == ' ')
                            {
                                j++;
                            }

                            // /> 로 끝나는가?
                            if(j+1>=pages[i].size() || pages[i][j]!='/' || pages[i][j+1]!='>')
                            {
                                break;
                            }
                            j++;

                            name_idx[name] = i;
                            //cout << "name " << name << endl;
                            goto match;
                        }
                    }
                }
                else if (pages[i][j]=='a')
                {
                    for(int k=1;k<external_url_prefix.size();k++)
                    {
                        if(pages[i][j] != external_url_prefix[k])
                        {
                            break;
                        }

                        j++;

                        if(k==external_url_prefix.size()-1)
                        {
                            string url="";

                            while(j<pages[i].size() && pages[i][j] != '"')
                            {
                                url+=pages[i][j];
                                j++;
                            }

                            // " 로 끝나는가?
                            if(j>=pages[i].size() || pages[i][j] != '"')
                            {
                                break;
                            }

                            j++;
                            // 공백 jump
                            while(j<pages[i].size() && pages[i][j] == ' ')
                            {
                                j++;
                            }

                            // > 로 끝나는가?
                            if(j>=pages[i].size() || pages[i][j]!='>')
                            {
                                break;
                            }

                            external_url[i].insert(url);

                            goto match;
                        }
                    }
                }
                else
                {
                    j--;
                }
            }
            else
            {
                if (j==0 || !is_char(pages[i][j-1]))
                {
                    bool corr = false;
                    for (int k=0;k<word.size();k++)
                    {
                        char ch = pages[i][j];

                        if (is_upper(ch))
                        {
                            ch = toggle_case(ch);
                        }

                        if (word[k] != ch)
                        {
                            if (k)
                            {
                                j--;
                            }
                            goto match;
                        }

                        j++;

                        if (j == pages[i].size())
                        {
                            goto match;
                        }

                        if (k == word.size()-1)
                        {
                            corr = true;
                        }
                    }

                    if (corr)
                    {
                        if (j==pages[i].size() || !is_char(pages[i][j]))
                        {
                            basic[i]++;
                        }
                    }

                    j--;
                }
            }
            match:;
        }
    }
}

// 기본점수, 외부 링크 수, 링크점수= 기본점수/외링, 그리고 매칭점수
int solution(string word, vector<string> pages) 
{
    for (int i=0;i<word.size();i++)
    {
        if (is_upper(word[i]))
        {
            word[i] = toggle_case(word[i]);
        }
    }

    basic.resize(pages.size());
    external_url.resize(pages.size());
    link.resize(pages.size());
    total.resize(pages.size());

    get_pi(word);
    solve(word, pages);

    for (int i=0;i<pages.size();i++)
    {
        total[i] += basic[i];
        link[i] = (double)basic[i] / (double)external_url[i].size();
    }

    for (int i=0;i<pages.size();i++)
    {
        for (string url : external_url[i])
        {
            auto it = name_idx.find(url);

            if (it != name_idx.end()) {
                int idx = it->second;
                total[idx] += link[i];
            }
        }
    }

    for (int i=0;i<pages.size();i++)
    {
        if (max_score < total[i])
        {
            max_score = total[i];
            max_idx = i;
        }
    }

    return max_idx;
}

int main()
{
//     solution(
//         "blind",
// {
//         "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>",
//         "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>",
//         "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
//         }
//     );

    solution(
        "Muzi",
{
        "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
        "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
        }
        );
}