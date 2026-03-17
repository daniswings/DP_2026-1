package practice.ch02.inheritance;

// 클라이언트가 원하는 인터페이스, 필요로 하는 인터페이스 (=Target 인터페이스)
// Banner.java에서 정해진 이름으로 showWithParen(), showWithAster() 대신 원하는 메소드명으로
public interface Print {
    public abstract void printWeak();
    public abstract void printStrong();
}
