package hw.ch02;

public class Main {
    public static void main(String[] args) {
        System.out.println("[학번: 20240974 | 이름: 박다인] - SW 분석 및 설계 과제 2장");
        System.out.println("-------------------------------------------------------------");

        // 1. 기존 제공되는 한국 콘센트(220V) 생성
        KoreanOutlet outlet = new KoreanOutlet();
        
        // 2. 어댑터에 콘센트를 연결 -> Charger 인터페이스로 변환
        Charger adapter = new KoreanOutletAdapter(outlet);
        
        // 3. 스마트폰에 어댑터 연결
        Smartphone myPhone = new Smartphone(adapter);
        
        // 4. 스마트폰 충전 시작!!!
        myPhone.charge();

        System.out.println(); // just for 줄바꿈

    }
}