package practice.ch10;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0; // 이전에 낸 손의 값
    private int currentHandValue = 0; // 바로 직전에 낸 손의 값
    private int[][] history = { // 정수형이 들어가는 2차원 배열
        { 1, 1, 1, }, // 세 줄 다 초기값
        { 1, 1, 1, },
        { 1, 1, 1, },
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() { // 전략의 핵심!!
        int bet = random.nextInt(getSum(currentHandValue));
        int handvalue = 0; // 이번에 낼 손의 값
        if (bet < history[currentHandValue][0]) {
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handvalue = 1;
        } else {
            handvalue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHand(handvalue);
    }

    private int getSum(int handvalue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            // 행 번호는 고정, 열 번호가 0, 1, 2로 바뀜 -> 결국 그 행의 값을 다 더하는 역할 수행
            sum += history[handvalue][i]; 
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) { // 이겼으면
            history[prevHandValue][currentHandValue]++;
        } else { // 졌으면
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
