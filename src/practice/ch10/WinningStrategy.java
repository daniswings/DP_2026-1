package practice.ch10;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false; // 원래도 boolean은 항상 false로 초기되므로 생략해도 ok
    private Hand prevHand; // 이전에 낸 손

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() { // 기본 아이디어: 이번에 이기면 그대로 낸다
        if (!won) { // 이전에 졌으면 새로운 손을 하나 만든다
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
