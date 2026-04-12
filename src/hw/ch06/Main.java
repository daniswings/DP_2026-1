package hw.ch06;

import ch06.Sample.framework.Manager;
import ch06.Sample.framework.Product;
import ch06.Sample.UnderlinePen;
import ch06.Sample.MessageBox;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번: 20240974  이름: 박다인\n");

        // 준비
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('-');
        MessageBox mbox = new MessageBox('*');
        BorderLine bline = new BorderLine('=');

        // 등록
        // Manager에 3가지 장식 객체를 원형(Prototype)으로 미리 등록
        manager.register("underline", upen);
        manager.register("message", mbox);
        manager.register("border", bline);

        // 생성 & 사용
        System.out.println("===== Test 1: UnderlinePen =====");
        Product p1 = manager.create("underline");
        p1.use("Welcome");

        System.out.println("\n===== Test 2: MessageBox =====");
        Product p2 = manager.create("message");
        p2.use("Welcome");

        System.out.println("\n===== Test 3: BorderLine =====");
        // new 키워드 없이 등록된 이름("border")만으로 복사본을 생성하여 사용
        Product p3 = manager.create("border");
        p3.use("Welcome");

        // 복사 검증
        System.out.println("\n===== Clone Test =====");
        Product p3_copy = manager.create("border");
        
        // 원본 객체(p3) & 복사된 객체(p3_copy)가 서로 다른 인스턴스인지 메모리 주소값 검증
        if (p3 != p3_copy) {
            System.out.println("✓ 정상적으로 복사됨 (서로 다른 인스턴스)");
        } else {
            System.out.println("X 복사 실패");
        }
    }
}