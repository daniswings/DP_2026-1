package practice.ch02.inheritance;

// Banner 클래스는 이미 존재하는 클래스 (=Vendor 클래스 =강아지(멍멍() 제공), 수정 불가)
public class Main {
    public static void main(String[] args) {
        Banner banner = new Banner("Hello, world!");
        banner.showWithParen();
        banner.showWithAster();
    }
}
