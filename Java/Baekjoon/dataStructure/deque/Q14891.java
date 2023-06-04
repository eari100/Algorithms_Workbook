package Baekjoon.dataStructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14891 (톱니바퀴)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.05.05 (O)
 **/
// todo: 다른 풀이들을 보며 사고력을 높이자
public class Q14891 {
    static List<Gear> gearList;
    static int[] gearDirections;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        gearList = new ArrayList<>();

        for(int i=0;i<4;i++) {
            Gear gear = new Gear();
            gear.setLeftIndex(6);
            gear.setRightIndex(2);
            gear.setTwelveIndex(0);
            gear.setPoles(Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray());

            gearList.add(gear);
        }

        int turnCnt = Integer.parseInt(br.readLine());

        for(int i=0;i<turnCnt;i++) {
            st = new StringTokenizer(br.readLine());

            int gearNumber = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken()); // 1: 시계방향, -1: 반시계방향

            gearDirections = new int[4];
            gearDirections[gearNumber] = direction;

            searchDirectionOfGear(gearNumber - 1, -1);
            searchDirectionOfGear(gearNumber + 1, 1);

            rotateGear();
        }

        br.close();

        System.out.print(getScore());
    }

    private static void searchDirectionOfGear(int gearNumber, int direction) {
        if(gearNumber == -1 || gearNumber == gearDirections.length)
            return;

        Gear currentGear = gearList.get(gearNumber);
        Gear prevGear = gearList.get(gearNumber - direction);

        if(direction == -1) {
            int currentRightIndex = currentGear.getRightIndex();
            int prevLeftIndex = prevGear.getLeftIndex();

            if(currentGear.getPoles()[currentRightIndex] != prevGear.poles[prevLeftIndex]) {
                gearDirections[gearNumber] = -gearDirections[gearNumber - direction];
                searchDirectionOfGear(gearNumber-1, direction);
            }
        }

        else if(direction == 1) {

            int currentLeftIndex = currentGear.getLeftIndex();
            int prevRightIndex = prevGear.getRightIndex();

            if(currentGear.poles[currentLeftIndex] != prevGear.getPoles()[prevRightIndex]) {
                gearDirections[gearNumber] = -gearDirections[gearNumber - direction];
                searchDirectionOfGear(gearNumber+1, direction);
            }
        }
    }

    private static void rotateGear() {
        for(int i=0;i<gearDirections.length;i++) {
            Gear gear = gearList.get(i);

            if(gearDirections[i] == -1) {
                gear.setLeftIndex((gear.getLeftIndex() + 1) % 8);
                gear.setRightIndex((gear.getRightIndex() + 1) % 8);
                gear.setTwelveIndex((gear.getTwelveIndex() + 1) % 8);
            } else if(gearDirections[i] == 1) {
                int leftIndex = gear.getLeftIndex() - 1;
                gear.setLeftIndex(leftIndex == -1 ? 7 : leftIndex);

                int rightIndex = gear.getRightIndex() - 1;
                gear.setRightIndex(rightIndex == -1 ? 7 : rightIndex);

                int twelveIndex = gear.getTwelveIndex() - 1;
                gear.setTwelveIndex(twelveIndex == -1 ? 7 : twelveIndex);
            }
        }
    }

    private static int getScore() {
        int score = 0;

        Gear firstGear = gearList.get(0);
        if(firstGear.getPoles()[firstGear.getTwelveIndex()] == 1) {
            score += 1;
        }

        Gear secondGear = gearList.get(1);
        if(secondGear.getPoles()[secondGear.getTwelveIndex()] == 1) {
            score += 2;
        }

        Gear thirdGear = gearList.get(2);
        if(thirdGear.getPoles()[thirdGear.getTwelveIndex()] == 1) {
            score += 4;
        }

        Gear fourthGear = gearList.get(3);
        if(fourthGear.getPoles()[fourthGear.getTwelveIndex()] == 1) {
            score += 8;
        }

        return score;
    }

    public static class Gear {
        private int leftIndex;
        private int rightIndex;
        private int twelveIndex;
        private int[] poles;

        public int getLeftIndex() {
            return leftIndex;
        }

        public int getRightIndex() {
            return rightIndex;
        }

        public int getTwelveIndex() {
            return twelveIndex;
        }

        public int[] getPoles() {
            return poles;
        }

        public void setLeftIndex(int leftIndex) {
            this.leftIndex = leftIndex;
        }

        public void setRightIndex(int rightIndex) {
            this.rightIndex = rightIndex;
        }

        public void setTwelveIndex(int twelveIndex) {
            this.twelveIndex = twelveIndex;
        }

        public void setPoles(int[] poles) {
            this.poles = poles;
        }
    }
}
