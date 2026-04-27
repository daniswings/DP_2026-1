package practice.ch06.framework;

// Product와 Cloneable은 모두 인터페이스인데, 인터페이스끼리는 상속 가능
public interface Product extends Cloneable { 
// public interface product { 이거 말고 윗줄로 하면 정상 실행됨
    public abstract void use(String s);
    public abstract Product createCopy(); // 복제하는 메소드 - 프로토타입의 핵심
}
