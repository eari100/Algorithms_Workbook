package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *@source: https://www.acmicpc.net/problem/1343 (폴리오미노)
 *@classfication: greedy
 *@reference: 더 좋은 풀이(데이터 전처리): https://www.acmicpc.net/source/13803570
 **/
public class Q1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        List<Integer> boardList = new ArrayList<>();
        int board, w;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='X') board = w = 1;
            else board = w = -1;

            while(i+1 < str.length()) {
                if(str.charAt(i) != str.charAt(i+1)) break;
                i++;
                board += w;
            }
            boardList.add(board);
        }

        StringBuilder sb = new StringBuilder();

        for(int i : boardList) {
            String s = greedy(i);

            if(s.equals("-1")) {
                sb = new StringBuilder("-1");
                break;
            }
            sb.append(s);
        }
        System.out.print(sb);
    }

    private static String greedy(int board) {
        StringBuilder sb = new StringBuilder();

        if(board < 0) return sb.append(".".repeat(-board)).toString();

        sb.append("AAAA".repeat(board/4));
        board %= 4;

        sb.append("BB".repeat(board/2));
        board %= 2;

        return board == 0 ? sb.toString() : "-1";
    }
}
