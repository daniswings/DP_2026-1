package hw.ch05;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("학번: 20240974  이름: 박다인");
        System.out.println();
        System.out.println("========== 방식 3: Enum (권장) ==========");
        
        LoggerEnum logger3a = LoggerEnum.INSTANCE;
        LoggerEnum logger3b = LoggerEnum.INSTANCE;
        
        logger3a.log("Enum Message 1");
        logger3b.log("Enum Message 2");
        
        if (logger3a == logger3b) {
            System.out.println("✓ 동일한 인스턴스");
        } else {
            System.out.println("X 다른 인스턴스");
        }
        
        System.out.println();
        System.out.println("========== 로그 출력 3 ==========");
        System.out.println("[LoggerEnum 로그]");
        System.out.print(logger3a.getLog());
    }
}