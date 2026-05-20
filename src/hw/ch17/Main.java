package hw.ch17;

import ch17.Sample.Observer;
import ch17.Sample.DigitObserver;
import ch17.Sample.GraphObserver;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번: 20240974  이름: 박다인\n");

        // 0부터 30 미만까지의 짝수 생성기 객체 만들기
        EvenNumberGenerator generator = new EvenNumberGenerator(0, 30);
        
        // 관찰자 객체 3개 생성
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        Observer observer3 = new RangeObserver();
        
        // 생성기에 관찰자들 등록하기
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.addObserver(observer3);
        
        // 수 생성 및 관찰 시작
        generator.execute();
    }
}