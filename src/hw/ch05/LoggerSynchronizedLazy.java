package hw.ch05;

public class LoggerSynchronizedLazy {
    // 최초에는 인스턴스 생성 x
    private static LoggerSynchronizedLazy instance = null;
    private StringBuilder logBuffer;

    // 생성자 private으로 설정
    private LoggerSynchronizedLazy() {
        System.out.println("[LoggerSynchronizedLazy] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder();
    }

    // 다중 스레드 환경에서도 안전하도록 synchronized 키워드 사용
    public static synchronized LoggerSynchronizedLazy getInstance() {
        // 인스턴스가 없을 때만 새로 생성 (지연 초기화)
        if (instance == null) {
            instance = new LoggerSynchronizedLazy();
        }
        return instance; // 이미 있으면 -> 기존 인스턴스 반환
    }

    public void log(String message) {
        logBuffer.append("[").append(System.currentTimeMillis()).append("] ").append(message).append("\n");
        System.out.println("[LoggerSynchronizedLazy] " + message);
    }

    public String getLog() {
        return logBuffer.toString();
    }
}