package practice.ch17;

// 관찰자
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) { // 통지받을 때 호출되는 메소드
        // 관찰자가 하는 일
        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            // 아래 문장 사용하려면 꼭 try-catch문으로 감싸야 함
            Thread.sleep(1000); // 1초 대기한다
        } catch (InterruptedException e) { // sleep 실패 시 발생하는 예외
        }
    }
}
