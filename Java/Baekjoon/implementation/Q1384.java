package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1384 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int groupNumber = 1;

        while(true) {
            int groupCount = Integer.parseInt(br.readLine());
            if(groupCount == 0) break;

            result.append("Group ").append(groupNumber).append('\n');
            String[] members = new String[groupCount];
            String[][] papers = new String[groupCount][groupCount-1];
            boolean badMsgFlag = false;

            for(int i=0;i<groupCount;i++) {
                StringTokenizer groupData = new StringTokenizer(br.readLine());

                String memberName = groupData.nextToken();
                members[i] = memberName;

                for(int j=0;j<groupCount-1;j++) {
                    String msg = groupData.nextToken();
                    papers[i][j] = msg;

                    if(msg.equals("N")) {
                        badMsgFlag = true;
                    }
                }
            }

            if(!badMsgFlag) {
                result.append("Nobody was nasty").append('\n');
            } else {
                for(int i=0;i<groupCount;i++) {
                    for(int j=0;j<groupCount-1;j++) {
                        if(papers[i][j].equals("N")) {
                            int fromMemberIdx = i;
                            int minus = j+1;

                            int toMemberIdx = fromMemberIdx - minus;

                            if(toMemberIdx < 0) {
                                toMemberIdx = groupCount + toMemberIdx;
                            }

                            result.append(members[toMemberIdx]).append(' ').append("was nasty about ").append(members[fromMemberIdx]).append('\n');
                        }
                    }
                }
            }

            result.append('\n');
            ++groupNumber;
        }

        br.close();

        System.out.print(result);
    }
}
