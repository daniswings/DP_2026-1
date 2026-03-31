package practice.ch05;

public class Main {
    public static void main(String[] args) {
        // Singleton s1 = new Singleton(); // 컴파일 에러: Singleton() has private access in Singleton
        Singleton s2 = Singleton.getInstance(); // Singleton이라는 클래스에 getInstance()라는 메소드를 호출해서 객체를 얻어감
        Singleton s3 = Singleton.getInstance(); // 여기까지 출력 시 같은 문장 2번 출력됨 -> 아직 Singleton 객체가 생성된 것은 아님을 알 수 있음
        // but  Singleton.java에서 (3) 작성 후에는 "Singleton 객체가 생성됩니다."가 1번만 출력됨
    
        if (s2 == s3) { // s2와 s3가 같은 객체를 참조하고 있는지, 즉 주소가 같은지 비교
            System.out.println("s2와 s3는 같은 Singleton 객체입니다.");
        } else {
            System.out.println("s2와 s3는 다른 Singleton 객체입니다.");
        }

        System.out.println("s2의 값: " + s2); // '어떤 클래스에 속하는지@주소' 순으로 출력
        System.out.println("s3의 값: " + s3);
        
        // Singleton2 사용하기
        Singleton2 s4 = Singleton2.INSTANCE; // Singleton2 객체 얻기
        s4.hello(); // Singleton2 객체의 hello 메소드 호출
    }
}
