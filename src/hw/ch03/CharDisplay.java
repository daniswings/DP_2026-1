package hw.ch03;

public class CharDisplay extends AbstractDisplay {
    private char ch;

    // for 기존 코드와 호환성 유지: 반복 횟수 명시 x 시 -> 기본값 5 사용
    public CharDisplay(char ch) {
        super(5); // 부모 생성자 호출
        this.ch = ch;
    }

    // 반복 횟수를 인자로 받는 생성자 추가
    public CharDisplay(char ch, int repeatCount) {
        super(repeatCount); 
        this.ch = ch;
    }
    
    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
