package hw.ch03;


public class StringDisplay extends AbstractDisplay {
    private String string;
    private int width;

    // for 기존 코드와 호환성 유지: 반복 횟수 명시 x 시 -> 기본값 5 사용
    public StringDisplay(String string) {
        super(5);
        this.string = string;
        this.width = string.length();
    }

    // 반복 횟수를 인자로 받는 생성자를 추가
    public StringDisplay(String string, int repeatCount) {
        super(repeatCount);
        this.string = string;
        this.width = string.length();
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    // open과 close에서 호출되어 "+----+" 문자열을 표시하는 메소드
    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
