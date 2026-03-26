package practice.ch04;

import practice.ch04.framework.Product;// Main과 IDCard는 서로 다른 패키지에 속하므로 import 필요
import practice.ch04.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        // (1)IDCard를 직접 생성 (클라이언트가 직접 생성하지 못하도록 아래 두 줄 주석 처리)
        // IDCard c1 = new IDCard("박다인"); // 생성 후
        // c1.use(); // 사용

        // (2) 공장을 통해서 IDCard 생성
        IDCardFactory factory = new IDCardFactory();
        Product c2 = factory.create("박다인"); // IDCard c2 대신 Product c2로 적어줘야 함
        c2.use();
    }
}