package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2621 (카드게임)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.03.03 (O)
 **/
public class Q2621 {
    static Card[] cards = new Card[5];

    static boolean 모두_같은_색_여부;
    static boolean 카드가_모두_같은_색인가_메서드_호출_여부;

    static boolean 모두_연속적인_숫자_여부;
    static boolean 카드가_모두_연속적인_숫자인가_메서드_호출_여부;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int bestScore = 0;

        for(int i=0;i<5;i++) {
            st = new StringTokenizer(br.readLine());
            String color = st.nextToken();
            int number = Integer.parseInt(st.nextToken());

            Card card = new Card(color, number);
            cards[i] = card;
        }

        br.close();

        Arrays.sort(cards, (card1, card2) -> card1.number - card2.number);

        if(카드가_모두_같은_색인가() && 카드가_모두_연속적인_숫자인가())
            bestScore = 900 + cards[4].number;
        else if(카드_4장의_숫자가_같은가())
            bestScore = 800 + cards[1].number;
        else if(카드_3장의_숫자와_2장의_숫자가_같은가())
            bestScore = 700 + cards[0].number * 10 + cards[4].number;
        else if(카드가_모두_같은_색인가())
            bestScore = 600 + cards[4].number;
        else if(카드가_모두_연속적인_숫자인가())
            bestScore = 500 + cards[4].number;
        else if(카드_3장의_숫자가_같은가())
            bestScore = 400 + cards[2].number;
        else if(카드_2장_숫자가_같고_또_다른_2장의_숫자가_같은가())
            bestScore = 300 + cards[1].number * 10 + cards[0].number;
        else if(카드_2장_숫자가_같은가())
            bestScore = 200 + cards[0].number;
        else
            bestScore = 100 + cards[4].number;

        System.out.print(bestScore);
    }

    private static boolean 카드가_모두_같은_색인가() {
        if(카드가_모두_같은_색인가_메서드_호출_여부) return 모두_같은_색_여부;

        카드가_모두_같은_색인가_메서드_호출_여부 = true;

        for(int i=1;i<cards.length;i++)
            if(!cards[i-1].color.equals(cards[i].color))
                return 모두_같은_색_여부 = false;

        return 모두_같은_색_여부 = true;
    }

    private static boolean 카드가_모두_연속적인_숫자인가() {
        if(카드가_모두_연속적인_숫자인가_메서드_호출_여부) return 모두_연속적인_숫자_여부;

        카드가_모두_연속적인_숫자인가_메서드_호출_여부 = true;

        for(int i=1;i<cards.length;i++)
            if(cards[i-1].number + 1 != cards[i].number)
                return 모두_연속적인_숫자_여부 = false;

        return 모두_연속적인_숫자_여부 = true;
    }

    private static boolean 카드_4장의_숫자가_같은가() {
        if(cards[0].number == cards[cards.length-2].number) return true;
        else if(cards[cards.length-1].number == cards[1].number) return true;

        return false;
    }

    private static boolean 카드_3장의_숫자와_2장의_숫자가_같은가() {
        if(cards[0].number == cards[2].number && cards[3].number == cards[4].number) return true;
        else if(cards[0].number == cards[1].number && cards[2].number == cards[4].number) {
            cards = swapCard(cards, 0, 4);

            return true;
        }

        return false;
    }

    private static boolean 카드_3장의_숫자가_같은가() {
        if(cards[0].number == cards[2].number) return true;
        else if(cards[2].number == cards[4].number) return true;

        return false;
    }

    private static boolean 카드_2장_숫자가_같고_또_다른_2장의_숫자가_같은가() {
        if(cards[0].number == cards[1].number && cards[2].number == cards[3].number) {
            cards = swapCard(cards, 1, 2);

            return true;
        } else if(cards[1].number == cards[2].number && cards[3].number == cards[4].number) {
            cards = swapCard(cards, 1, 3);

            return true;
        } else if(cards[0].number == cards[1].number && cards[3].number == cards[4].number) {
            cards = swapCard(cards, 1, 3);

            return true;
        }

        return false;
    }

    private static boolean 카드_2장_숫자가_같은가() {
        int tmpNumber = cards[0].number;

        for(int i=1;i<cards.length;i++) {
            if(cards[i].number == tmpNumber) {
                cards = swapCard(cards, 0, i);
                return true;
            }

            tmpNumber = cards[i].number;
        }

        return false;
    }

    private static Card[] swapCard(Card[] cards, int index1, int index2) {
        Card tmpCard = new Card();
        tmpCard.color = cards[index1].color;
        tmpCard.number = cards[index1].number;

        cards[index1] = cards[index2];
        cards[index2]= tmpCard;

        return cards;
    }

    public static class Card {
        private String color;
        private int number;

        public Card() {}

        public Card(String color, int number) {
            this.color = color;
            this.number = number;
        }
    }
}
