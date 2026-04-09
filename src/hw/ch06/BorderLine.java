package hw.ch06;

import ch06.Sample.framework.Product;

public class BorderLine implements Product {
    private char borderChar;

    // 생성자 - 외부에서 테두리로 사용할 문자 받아 초기화
    public BorderLine(char borderChar) {
        this.borderChar = borderChar;
    }

    // 텍스트 길이 맞춰서 위아래 테두리 & 본문 분리 출력
    @Override
    public void use(String s) {
        int length = s.length();
        
        // 위쪽 라인 print
        for (int i = 0; i < length; i++) {
            System.out.print(borderChar);
        }
        System.out.println();
        
        // 본문 print
        System.out.println(s);
        
        // 아래쪽 라인 print
        for (int i = 0; i < length; i++) {
            System.out.print(borderChar);
        }
        System.out.println();
    }

    // clone() 활용 -> 자신과 동일한 인스턴스 복제 (-> Prototype 패턴 핵심!)
    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product)clone(); // 자신을 복제
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}