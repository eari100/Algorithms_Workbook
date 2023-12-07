package Baekjoon.dataStructure.hash.map;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @source:https://www.acmicpc.net/problem/20920 (영단어 암기는 괴로워)
 * @classification: hashmap
 * @문제 푼 날짜 (자력으로 풂?): 23.12.07 (X, hashmap 정렬 chatGPT가 해줌)
 **/
// todo: 알파벳 정렬 시 TreeSet 활용해볼 것
public class Q20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int wordCnt = Integer.parseInt(st.nextToken());
        int minWordLength = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> words = new HashMap<>();

        for(int i=0;i<wordCnt;i++) {
            String word = br.readLine();
            if(word.length() >= minWordLength) {
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

        br.close();

        StringBuilder sortedWords = new StringBuilder();

        words.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Comparator.<Map.Entry<String, Integer>>comparingInt(entry -> entry.getKey().length()).reversed())
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> sortedWords.append(entry.getKey()).append('\n'));

        bw.write(sortedWords.toString());
        bw.flush();
        bw.close();
    }
}
