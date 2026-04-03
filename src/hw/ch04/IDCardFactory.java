package hw.ch04;

public class IDCardFactory extends Factory {
    private int serial = 100; // 시리얼 번호 카운터
    private String baseDate; // 발급 기준 날짜

    // 카드 발급 기준 날짜를 받는 생성자 IDCardFactory(String baseDate) 추가
    public IDCardFactory(String baseDate) {
        this.baseDate = baseDate;
    }
    
    @Override
    protected Product createProduct(String owner) { // baseDate를 사용해 발급 날짜를 설정하도록 createProduct() 메서드 수정
        return new IDCard(owner, serial++, baseDate);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
