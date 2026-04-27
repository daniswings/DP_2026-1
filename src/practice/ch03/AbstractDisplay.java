package practice.ch03;

public abstract class AbstractDisplay {
    // open, print, close는 하위 클래스에 구현을 맡기는 추상 메소드 
    abstract protected void open();
    public abstract void print();
    public abstract void close();

    // display는 AbstractDisplay에서 구현하는 메소드 
    // open 한 번, print 다섯 번, close 한 번이라는 큰 틀(흐름. 구조)을 제공하는 템플릿 메소드 
    // -> but 실제 구현은 하위 클래스가 하므로 실제 구현된 모습은 알 수 x

    // final: 하위 클래스에서 오버라이드 할 수 없다 (큰 흐름은 자식들이 바꿀 수 없다)
    public final void display() { 
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
