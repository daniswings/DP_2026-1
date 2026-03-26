package practice.ch03;

public class Main {
    public static void main(String[] args) {
        // CharDisplay d1 = new CharDisplay('H'); // 작은 따옴표로 감싸주면 char 타입, 큰 따옴표로 감싸주면 String 타입
        AbstractDisplay d1 = new CharDisplay('H'); // 이렇게 부모 타입으로 선언해도 가능
        d1.display();
        d1.open();

        // StringDisplay d2 = new StringDisplay("Hello, world.");
        AbstractDisplay d2 = new StringDisplay("Hello, world."); // 위와 마찬가지로 StringDisplay 대신 AbstractDisplay로 선언해도 가능 (LSP 원칙이 잘 지켜짐)
        d2.display();
        d2.open();
    }
}
