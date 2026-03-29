package hw.ch03;

public abstract class AbstractDisplay {
    private int repeatCount; // 반복 횟수 저장 필드를 추가

    // 생성자에서 반복 횟수를 인자로 받도록 확장
    public AbstractDisplay(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public abstract void open();
    public abstract void print();
    public abstract void close();

    public final void display() {
        open();
        for (int i = 0; i < repeatCount; i++) { // 필드값 repeatCount 사용하게 변경
            print();
        }
        close();
    }
}
