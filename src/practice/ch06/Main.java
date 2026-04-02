package practice.ch06;

import practice.ch06.framework.Product;

public class Main {
    public static void main(String[] args) {
        MessageBox mbox1 = new MessageBox('*');
        mbox1.use("Hello, world."); // use에 String 넣어줌

        mbox1.createCopy().use("Hello, World.");
        // mbox1.clone(); 같은 형태로는 호출 불가 (왜냐면 클론은 자기 클래스 안에서만 호출 가능)
    }
}
