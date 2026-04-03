package hw.ch04.license;

import hw.ch04.Factory;
import hw.ch04.Product;
import java.time.LocalDate; // 날짜 계산용

public class LicenseCardFactory extends Factory {
    private int licenseCounter = 100;
    private String baseDate;

    public LicenseCardFactory(String baseDate) {
        this.baseDate = baseDate;
    }

    @Override
    protected Product createProduct(String holder) {
        // 발급일 기준, 만료일은 5년 뒤의 하루 전날로 계산
        LocalDate issued = LocalDate.parse(baseDate);
        LocalDate expiry = issued.plusYears(5).minusDays(1);
        
        // 문자열로 변환해 전달함
        LicenseCard card = new LicenseCard(holder, licenseCounter, baseDate, expiry.toString());
        licenseCounter++;
        
        return card;
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println("운전면허증이 정상적으로 등록되었습니다.");
    }
}