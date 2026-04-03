package hw.ch05;

public class LoggerStaticInit {
    // Static Initializer - 클래스가 로드될 때 바로 인스턴스를 생성
    private static final LoggerStaticInit instance = new LoggerStaticInit();
    private StringBuilder logBuffer;

    // 생성자를 private으로 설정 -> 외부에서 객체 생성 방지
    private LoggerStaticInit() {
        System.out.println("[LoggerStaticInit] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder();
    }

    // 유일한 인스턴스 반환하는 메서드
    public static LoggerStaticInit getInstance() {
        return instance;
    }

    public void log(String message) {
        logBuffer.append("[").append(System.currentTimeMillis()).append("] ").append(message).append("\n");
        System.out.println("[LoggerStaticInit] " + message);
    }

    public String getLog() {
        return logBuffer.toString();
    }
}
