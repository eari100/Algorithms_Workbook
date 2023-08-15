package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/28457 (Every? Only One's Marble)
 * @classfication: implementation
 * @upsolving: true
 * @문제 푼 날짜 (자력으로 풂?): 23.08.15 (O, 구현 문제는 지문을 꼼꼼하게 읽을 것)
 **/
public class Q28457 {
    static final String WIN = "WIN";
    static final String LOSE = "LOSE";
    static int 나의_위치 = 0;
    static long 나의_돈 = 0;
    static int 월급 = 0;
    static int[] 황금_열쇠_타입;
    static int[] 황금_열쇠_변수;
    static long 사회복지기부액 = 0;
    static final String 시작 = "시작";
    static final String 무인도 = "무인도";
    static final String 사회복지 = "사회복지";
    static final String 우주여행 = "우주여행";
    static final String 도시 = "도시";
    static final String 황금카드 = "황금카드";
    static String[] 보드_칸_타입;
    static int[] 땅의_가격;
    static boolean[] 땅_구매_여부;
    static int 내가_보유한_땅의_갯수 = 0;
    static int 전체_땅의_갯수 = 0;
    static int 보드의_크기;
    static final int 무인도_휴식_횟수 = 3;
    static int 턴_수 = 0;
    static int 현재턴 = 1;
    static int 황금_열쇠_인덱스 = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        나의_돈 = Integer.parseInt(st.nextToken());
        월급 = Integer.parseInt(st.nextToken());

        int 황금_열쇠_갯수 = Integer.parseInt(st.nextToken());
        황금_열쇠_타입 = new int[황금_열쇠_갯수];
        황금_열쇠_변수 = new int[황금_열쇠_갯수];

        for(int i=0;i<황금_열쇠_갯수;i++) {
            st = new StringTokenizer(br.readLine());

            황금_열쇠_타입[i] = Integer.parseInt(st.nextToken());
            황금_열쇠_변수[i] = Integer.parseInt(st.nextToken());
        }

        보드의_크기 = 4*n - 4;

        보드_칸_타입 = new String[보드의_크기];
        땅의_가격 = new int[보드의_크기];
        땅_구매_여부 = new boolean[보드의_크기];

        for(int i=0;i<보드의_크기;i++) {
            if(i == 0) {
                보드_칸_타입[i] = 시작;
            } else if(i == n-1) {
                보드_칸_타입[i] = 무인도;
            } else if(i == 2*n-2) {
                보드_칸_타입[i] = 사회복지;
            } else if(i == 3*n-3) {
                보드_칸_타입[i] = 우주여행;
            } else {
                st = new StringTokenizer(br.readLine());
                String 타입 = st.nextToken();

                if(타입.equals("L")) {
                    보드_칸_타입[i] = 도시;
                    ++전체_땅의_갯수;
                    땅의_가격[i] = Integer.parseInt(st.nextToken());
                } else if(타입.equals("G")) {
                    보드_칸_타입[i] = 황금카드;
                }
            }
        }

        턴_수 = Integer.parseInt(br.readLine());

        for(현재턴=1;현재턴<=턴_수;현재턴++) {
            st = new StringTokenizer(br.readLine());
            int 주사위1 = Integer.parseInt(st.nextToken());
            int 주사위2 = Integer.parseInt(st.nextToken());
            int 이동할_거리 = 주사위1 + 주사위2;

            나의_위치를_이동한다(이동할_거리);
        }

        br.close();

        턴_종료_승패연산();
    }

    private static void 땅을_구매한다() {
        if(땅_구매_여부[나의_위치]) return;
        if(나의_돈 < 땅의_가격[나의_위치]) return;

        나의_돈 -= 땅의_가격[나의_위치];
        ++내가_보유한_땅의_갯수;
        땅_구매_여부[나의_위치] = true;
    }

    private static void 주사위_이벤트를_발생한다() throws IOException {
        String 보드_타입 = 보드_칸_타입[나의_위치];

        if(보드_타입.equals(시작)) {
            return;
        } else if(보드_타입.equals(무인도)) {
            무인도에_도착하다();
        } else if(보드_타입.equals(사회복지)) {
            사회복지기금을_받는다();
        } else if(보드_타입.equals(우주여행)) {
            우주여행을_가다();
        } else if(보드_타입.equals(도시)) {
            땅을_구매한다();
        } else if(보드_타입.equals(황금카드)) {
            황금_열쇠에_대한_행동을_한다();
        } else {
            throw new IllegalArgumentException("유효하지 않은 주사위 타입입니다.");
        }
    }

    private static void 턴_종료_승패연산() {
        if (전체_땅의_갯수 == 내가_보유한_땅의_갯수) {
            게임_승리();
        } else {
            게임_패배();
        }
    }

    private static void 무인도에_도착하다() throws IOException {
        for(int i=0;i<무인도_휴식_횟수;i++) {
            ++현재턴;

            if(현재턴 > 턴_수) return;

            st = new StringTokenizer(br.readLine());
            int 주사위1 = Integer.parseInt(st.nextToken());
            int 주사위2 = Integer.parseInt(st.nextToken());

            if(주사위1 == 주사위2) return;
        }
    }

    private static void 우주여행을_가다() {
        나의_돈 += 월급;
        나의_위치 = 0;
    }

    private static void 황금_열쇠에_대한_행동을_한다() throws IOException {
        int 타입 = 황금_열쇠_타입[황금_열쇠_인덱스];
        int 변수 = 황금_열쇠_변수[황금_열쇠_인덱스];

        if (타입 == 1) {
            돈을_받는다(변수);
        } else if (타입 == 2) {
            돈을_준다(변수);
        } else if (타입 == 3) {
            사회복지기금에_기부한다(변수);
        } else if (타입 == 4) {
            나의_위치를_이동한다(변수);
        } else {
            throw new IllegalArgumentException("유효하지 않은 황금 열쇠 타입입니다.");
        }

        ++황금_열쇠_인덱스;
        황금_열쇠_인덱스 %= 황금_열쇠_변수.length;
    }

    private static void 게임_승리() {
        System.out.print(WIN);
        System.exit(0);
    }

    private static void 게임_패배() {
        System.out.print(LOSE);
        System.exit(0);
    }

    private static void 돈을_받는다(long money) {
        나의_돈 += money;
    }

    private static void 돈을_준다(long money) {
        if(나의_돈 >= money) {
            나의_돈 -= money;
        } else {
            게임_패배();
        }
    }

    private static void 사회복지기금에_기부한다(long money) {
        돈을_준다(money);
        사회복지기부액 += money;
    }

    private static void 나의_위치를_이동한다(int 이동할_거리) throws IOException {
        int 선형거리 = 나의_위치 + 이동할_거리;
        나의_돈 += 월급 * (선형거리 / 보드의_크기);
        나의_위치 = 선형거리 % 보드의_크기;

        주사위_이벤트를_발생한다();
    }
    private static void 사회복지기금을_받는다() {
        나의_돈 += 사회복지기부액;
        사회복지기부액 = 0;
    }
}
