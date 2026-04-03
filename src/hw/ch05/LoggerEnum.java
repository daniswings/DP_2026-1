package hw.ch05;

public enum LoggerEnum {
    // 클래스 로드 시 단 하나의 인스턴스(상수)만 생성됨 보장
    INSTANCE;

    private StringBuilder logBuffer;

    // Enum의 생성자 - 기본적으로 private으로 동작
    LoggerEnum() {
        System.out.println("[LoggerEnum] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder();
    }

    public void log(String message) {
        logBuffer.append("[").append(System.currentTimeMillis()).append("] ").append(message).append("\n");
        System.out.println("[LoggerEnum] " + message);
    }

    public String getLog() {
        return logBuffer.toString();
    }
}
