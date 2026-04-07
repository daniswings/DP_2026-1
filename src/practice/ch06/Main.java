package practice.ch06;

import practice.ch06.framework.Manager;
import practice.ch06.framework.Product;

public class Main {
    public static void main(String[] args) {
        /*
        // 원본(=prototype)이 일을 함
        MessageBox mbox1 = new MessageBox('*');
        mbox1.use("Hello, world."); // use에 String 넣어줌

        // 복제된 객체가 일을 함
        mbox1.createCopy().use("Hello, World.");
        // mbox1.clone(); 같은 형태로는 호출 불가 (왜냐면 클론은 자기 클래스 안에서만 호출 가능)

        // 원본이 일을 함
        UnderlinePen upen1 = new UnderlinePen('+');
        upen1.use("Hello, world.");

        // 복제된 객체가 일을 함
        upen1.createCopy().use("Hello, World.");

        */

        // Manager를 이용하는 코드

        // 준비 - Manager에 원본(prototype)을 등록
        Manager manager = new Manager();
        MessageBox mbox1 = new MessageBox('*');
        MessageBox mbox2 = new MessageBox('/');
        UnderlinePen upen1 = new UnderlinePen('+');

        // 등록
        manager.register("star box", mbox1);
        manager.register("plus line", upen1);
        manager.register("slash box", mbox2);

        // 사용 - 등록된 이름으로 복제품을 얻어서 사용
        Product p1 = manager.create("star box");
        p1.use("Hello, world.");

        Product p2 = manager.create("plus line");
        p2.use("Hello, world.");

        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");
    }
}
