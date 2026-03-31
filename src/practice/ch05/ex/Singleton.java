package practice.ch05.ex;

// 다른 방법으로 Singleton 패턴 적용하기
public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
        System.out.println("인스턴스가 생성되었습니다.");
        slowdown();
    }

    public static Singleton getInstance() { //getInstance가 만들어질 때 
        if (singleton == null) { // singleton이 null이면 / 처음 호출되는지 검사
            singleton = new Singleton(); // Singleton 객체를 하나 만들어서 singleton에 저장해라
        }
        return singleton; // 그 다음부터는 새로 만들지 않고 기존에 만들어진 singleton을 반환
    }

    private void slowdown() { // slowdown은 인스턴스 생성 시 시간을 지연시키는 역할
        try {
            Thread.sleep(1000); // CPU를 내놓고 쉬고 싶을 때 Thread.sleep() 호출 (1초 휴식)
        } catch (InterruptedException e) {
        }
    }
}
