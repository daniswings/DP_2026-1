package hw.ch02;

public class KoreanOutletAdapter implements Charger { // 구현 조건 2: Charger 인터페이스 구현
    private KoreanOutlet koreanOutlet; // 구현 조건 1: 위임 -> 따라서 기존 클래스 KoreanOutlet을 내부적으로 포함

    public KoreanOutletAdapter(KoreanOutlet koreanOutlet) {
        this.koreanOutlet = koreanOutlet;
    }

    @Override
    public int charge() {
        // 구현 조건 3: 기존 클래스 KoreanOutlet의 메소드 provide())를 호출해 새 인터페이스 charge())에 맞게 변환
        int voltage = koreanOutlet.provide();
        // 구현 조건 4: 220V를 그대로 반환
        return voltage; 
    }
}