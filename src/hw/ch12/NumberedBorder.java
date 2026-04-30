package hw.ch12;

import ch12.A2.Border;
import ch12.A2.Display;

public class NumberedBorder extends Border {
    
    // 생성자 - 장식할 내용물 Display를 받아 -> 부모 클래스인 Border의 생성자로 넘겨줌
    public NumberedBorder(Display display) {
        super(display);
    }

    // getColumns - 가로 폭은 기존 내용물 폭 + 행 번호 포맷의 길이 4 더해 반환
    @Override
    public int getColumns() {
        return display.getColumns() + 4;
    }

    // getRows - 행 수는 내용물 행 수와 동일 -> 그대로 반환
    @Override
    public int getRows() {
        return display.getRows();
    }

    // getRowText - 핵심! String.format 사용해 두 자리 정수, |, 공백으로 구성된
    //총 4글자짜리 format인 %2d| 을 원래 행 문자열 앞에 덧붙임
    @Override
    public String getRowText(int row) {
        return String.format("%2d| %s", row + 1, display.getRowText(row));
    }
}