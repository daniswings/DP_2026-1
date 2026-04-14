package ch10.Sample;

public class Main {
    public static void main(String[] args) { // 인자 args를 코드 안에서 사용 - 터미널에서 java main 111 222 333 444 작성 시 숫자 부분이 이 args에 들어감
        if (args.length != 2) { // 명령행 인자의 개수가 2개가 아니면 아래 두 코드처럼 작성하라고 사용법을 알려주고 종료
            System.out.println("Usage: java Main randomseed1 randomseed2");
            System.out.println("Example: java Main 314 15");
            System.exit(0);
        }

        // 중요 - 명령행 인자는 문자열이므로 숫자로 변환해야 함 (꼭 문자열로 전달해야 함!)
        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);

        Player player1 = new Player("KIM", new WinningStrategy(seed1));
        Player player2 = new Player("LEE", new ProbStrategy(seed2));
        
        for (int i = 0; i < 10000; i++) {
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
        System.out.println("Total result:");
        System.out.println(player1);
        System.out.println(player2);
    }
}
