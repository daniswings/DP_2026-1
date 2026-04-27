package practice.ch05;

// 싱글턴 패턴 적용하기 - 아래 클래스는 인스턴스 하나만 만듦
public class Singleton {
    // (3) Singleton 객체를 미리 하나 만들어 둠 (반드시 static 변수) -> very important!!
    private static Singleton singleton = new Singleton();

    // (1) 생성자를 private으로 함
    private Singleton() {
        System.out.println("Singleton 객체가 생성됩니다.");
    }

    // (2) Singleton 객체를 얻어갈 수 있는 메소드를 정의함
    // static으로 해줘야 클래스에 속해 객체 생성하지 않고도 호출 가능
    public static Singleton getInstance() { 
        return singleton; // (3)을 만든 후엔 Singleton() -> singleton으로 바꿔야 함
    }
}