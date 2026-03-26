package ch04.Sample; // Main.java는 클라이언트이므로 어느 패키지에도 속하지 않게

import ch04.Sample.framework.Product;
import ch04.Sample.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        IDCardFactory factory = new IDCardFactory();
        Product card1 = factory.create("Youngjin Kim");
        Product card2 = factory.create("Heungmin Son");
        Product card3 = factory.create("Kane");
        card1.use();
        card2.use();
        card3.use();

        System.out.println("\n--- 시리얼 100 조회 ---");
        String owner100 = factory.getOwner(100);
        System.out.println("시리얼 번호 100의 오너: " + owner100);
    }
}
