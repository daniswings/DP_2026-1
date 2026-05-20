package hw.ch17;

import ch17.Sample.NumberGenerator;

public class EvenNumberGenerator extends NumberGenerator {
    private int start;  // 시작값 (짝수)
    private int end;    // 종료값 (미포함)
    private int number; // 현재 생성된 수

    public EvenNumberGenerator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // 관찰자들이 현재 수를 가져갈 수 있도록 반환
    @Override
    public int getNumber() {
        return number;
    }

    // start부터 end 미만까지 짝수만 순서대로 생성하며 통지
    @Override
    public void execute() {
        for (int i = start; i < end; i += 2) {
            this.number = i;
            notifyObservers(); // 값이 바뀔 때마다 등록된 관찰자 전원에게 알림
        }
    }
}