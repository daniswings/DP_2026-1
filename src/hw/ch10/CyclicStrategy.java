package hw.ch10;

import ch10.A1.Hand;
import ch10.A1.Strategy;

public class CyclicStrategy implements Strategy {
    private int currentHandValue = 0; // 0(=바위)부터 시작

    // 다음 손 결정 (0 - > 1 -> 2 순환)
    @Override
    public Hand nextHand() {
        int handvalue = currentHandValue;
        // 3으로 나눈 나머지를 구해서 0, 1, 2 계속 반복되도록 함
        currentHandValue = (currentHandValue + 1) % 3; 
        return Hand.getHand(handvalue);
    }

    // 승패 학습 무시
    @Override
    public void study(boolean win) {
        // CyclicStrategy는 정해진 순서대로만 냄 -> 승패 결과가 다음 손에 영향 x -> 따라서 아무 작업도 하지 x
    }
}