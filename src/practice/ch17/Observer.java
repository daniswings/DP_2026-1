package practice.ch17;

// 관찰자를 나타내는 인터페이스(관찰자는 관찰대상이 통지하면 통지받는 역할)
public interface Observer {
    // 통지받을 때 호출되는 메소드
    public abstract void update(NumberGenerator generator);
}
