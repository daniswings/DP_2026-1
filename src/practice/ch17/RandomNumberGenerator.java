package practice.ch17;

import java.util.Random;

// 관찰 대상
public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random(); 	// 난수 생성기 
    private int number;                   		// 현재 수 

    // 수를 취득한다 
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다 
    // 관찰자 패턴의 핵심 - 상태가 바뀌면 관찰자에게 통지한다
    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            // 0부터 49까지의 난수를 생성
            number = random.nextInt(50);
            notifyObservers(); // 수가 바뀌었으므로 관찰자에게 통지하는 메서드
        }
    }
}
