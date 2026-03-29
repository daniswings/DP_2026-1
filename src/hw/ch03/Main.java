package hw.ch03;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번: 20240974, 이름: 박다인");
        System.out.println("--------------------------------");

        //[3-1] 기본 테스트 - 기존 코드 호환성 확인
        AbstractDisplay d1 = new CharDisplay('H'); // 기본 5회
        AbstractDisplay d2 = new StringDisplay("Hello"); // 기본 5회
        d1.display();
        d2.display();

        System.out.println(); // just for 줄바꿈

        // [3-2] Step 1 테스트: 반복 횟수 제어
        AbstractDisplay d3 = new CharDisplay('X', 3); // 3회
        AbstractDisplay d4 = new StringDisplay("Test", 7); // 7회
        d3.display();
        d4.display();

        System.out.println(); // just for 줄바꿈

        // [3-3] Step 2 테스트: 새로운 Display
        // NumberDisplay
        AbstractDisplay num = new NumberDisplay(42, 4); // 42를 4회 반복
        num.display();
    }
}
