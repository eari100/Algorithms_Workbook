package Baekjoon.dataStructure.linkedList;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1406 (에디터)
 * @classification: LinkedList & ListIterator
 * @문제 푼 날짜 (자력으로 풂?): 24.02.24 (X)
 * @reference: https://minhamina.tistory.com/17
 **/
// todo: stack 풀이
public class Q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> editor = new LinkedList<>();

        String baseStr = br.readLine();
        for(char c : baseStr.toCharArray())
            editor.add(c);

        ListIterator<Character> editorIter = editor.listIterator();
        int cmdCnt = Integer.parseInt(br.readLine());

        while(editorIter.hasNext()) {
            editorIter.next();
        }

        for(int i=0;i<cmdCnt;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("L")) {
                if(editorIter.hasPrevious())
                    editorIter.previous();
            } else if(cmd.equals("D")) {
                if(editorIter.hasNext())
                    editorIter.next();
            } else if(cmd.equals("B")) {
                if(editorIter.hasPrevious()) {
                    editorIter.previous();
                    editorIter.remove();
                }
            } else if(cmd.equals("P")) {
                char val = st.nextToken().charAt(0);

                editorIter.add(val);
            }
        }

        br.close();

        for(char c : editor) {
            bw.write(c);
        }

        bw.flush();
        bw.close();
    }
}
