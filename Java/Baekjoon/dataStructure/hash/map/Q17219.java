package Baekjoon.dataStructure.hash.map;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, String> hashMap = new HashMap<>();

        int siteCnt = Integer.parseInt(st.nextToken());
        int questionCnt = Integer.parseInt(st.nextToken());

        for(int i=0;i<siteCnt;i++) {
            st = new StringTokenizer(br.readLine());

            String site = st.nextToken(), pw = st.nextToken();
            hashMap.put(site, pw);
        }

        for(int i=0;i<questionCnt;i++) {
            String site = br.readLine();
            bw.write(hashMap.get(site));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
