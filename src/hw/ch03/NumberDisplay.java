package hw.ch03;

// AbstractDisplay를 확장 -> 새 Display 클래스 구현
public class NumberDisplay extends AbstractDisplay {
    private int number;

    // 숫자 & 반복 횟수를 인자로 받는 생성자
    public NumberDisplay(int number, int repeatCount) {
        super(repeatCount); // 부모 클래스에게 반복 횟수 전달 
        this.number = number;
    }

    @Override
    public void open() {
        System.out.println("<<Number>>"); // "<<Number>>"를 한 줄에 출력
    }

    @Override
    public void print() {
        System.out.println(number); // 숫자를 한 줄에 하나씩 출력
    }

    @Override
    public void close() {
        System.out.println("<<Number>>"); // "<<Number>>"를 한 줄에 출력
    }
}
