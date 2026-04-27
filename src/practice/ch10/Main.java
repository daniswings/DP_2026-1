package practice.ch10;

public class Main {
    public static void main(String[] args) {
        /* 
        // 손을 2개 생성
        Hand h1 = Hand.ROCK;
        Hand h2 = Hand.SCISSORS;

        // 손을 대결시킴
        if (h1.isStrongerThan(h2)) {
            System.out.println("h1이 이겼습니다.");
        } else if (h1.isWeakerThan(h2)) {
            System.out.println("h2가 이겼습니다.");
        } else {
            System.out.println("비겼습니다.");
        }
        */

        // 플레이어 2명 만들기
        Player player1 = new Player("박다인", new ProbStrategy(314));
        Player player2 = new Player("손흥민", new WinningStrategy(15));

        // 게임 시키기
        for (int i = 0; i < 1000; i++) {
            // 플레이어 2명에게 각각 손을 얻음
            Hand h1 = player1.nextHand();
            Hand h2 = player2.nextHand();

            // 손을 대결시킴
            if (h1.isStrongerThan(h2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            } else if (h1.isWeakerThan(h2)) {
                System.out.println("Winner: " + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }

        System.out.println("Total result:");
        // 굳이 명시하지 않아도 player1의 toString()이 자동으로 호출됨
        System.out.println(player1); 
        // 출력 결과 ProbStrategy가 WinningStrategy보다 승률이 높음 
        // -> ProbStrategy가 WinningStrategy보다 더 좋은 전략이라는 것을 알 수 있음
        System.out.println(player2); 
}

