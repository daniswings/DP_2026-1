package hw.ch10;

import ch10.A1.Hand;
import ch10.A1.Player;
import ch10.A1.RandomStrategy;
import ch10.A1.Strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번: 20240974  이름: 박다인\n");

        System.out.println("===== RandomStrategy =====");
        Player player1 = new Player("Taro", new RandomStrategy(0));
        
        System.out.println("\n===== CyclicStrategy =====");
        Player player2 = new Player("Bob", new CyclicStrategy());

        // CyclicStrategy 테스트: (9번) 순환함을 확인
        System.out.println("\n===== CyclicStrategy 의 손가락 순환 =====");
        Strategy cyclic = new CyclicStrategy();
        for (int i = 0; i < 9; i++) {
            Hand hand = cyclic.nextHand();
            System.out.println((i + 1) + "번째: " + hand);
            cyclic.study(false); // study 호출해도 영향 없음
        }

        // player1과 player2를 10번 게임 진행시킴
        System.out.println("\n===== 10번 게임 진행 결과 =====");
        for (int i = 0; i < 10; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner:" + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }
        
        System.out.println("\nTotal result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}