package practice.ch12;

// 중심 컴포넌트임(역할: 문자열을 표시해줌)
public class StringDisplay extends Display {
    private String string; // 표시할 문자열: "Hello, World." 

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() {
        return string.length();
    }

    @Override
    public int getRows() {
        return 1; // "Hello, World."의 행수는 1
    }

    @Override
    public String getRowText(int row) {
        if (row != 0) {
            // 배열에서 인덱스 범위 넘어가면 발생하는 오류
            throw new IndexOutOfBoundsException(); 
        }
        return string;
    }
}
