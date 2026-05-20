package hw.ch17;

import ch17.Sample.NumberGenerator;
import ch17.Sample.Observer;

public class RangeObserver implements Observer {
    
    // 수동적인 관찰자 역할 -> 통지가 오면 값을 읽어서 범위 레이블 출력
    @Override
    public void update(NumberGenerator generator) {
        int number = generator.getNumber();
        String label = "";
        
        // 범위 나눔
        if (number >= 0 && number < 10) {
            label = "Low";
        } else if (number >= 10 && number < 20) {
            label = "Mid";
        } else if (number >= 20) {
            label = "High";
        }
        
        System.out.println("RangeObserver: [" + label + "] " + number);
    }
}