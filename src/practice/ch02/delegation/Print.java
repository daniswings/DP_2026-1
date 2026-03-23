package practice.ch02.delegation;

// 클라이언트가 원하는 인터페이스, 필요로 하는 인터페이스, Target 인터페이스, but '추상' 클래스로 되어있음!
public abstract class Print {
    public abstract void printWeak();
    public abstract void printStrong();
}
