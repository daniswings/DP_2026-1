package practice.ch05.ex;

public class Main extends Thread {
    public static void main(String[] args) {
        // 스레드 객체 생성
        Main t1 = new Main("Thread-A");
        Main t2 = new Main("Thread-B");

        // 스레드에 시작해라 지시
        t1.start(); // 스레드가 해야 할 일을 작성한 run() 메소드가 자동으로 실행됨
        t2.start();
    }

    // 1 스레드가 해야 할 일을 작성
    @Override
    public void run() {
        Singleton s = Singleton.getInstance(); // 싱글톤 객체를 얻어오는 메서드 호출
        System.out.println(getName() + ": " + s); // 스레드 이름과 싱글톤 인스턴스의 참조값 출력
    }

    public Main(String name) {
        super(name); // 부모인 Thread 클래스의 생성자를 호출해서 스레드 이름 설정
    }
}