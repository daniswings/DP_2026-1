package ch04.A2.idcard;


import ch04.A2.framework.Factory;
import ch04.A2.framework.Product;
import java.util.HashMap;
import java.util.Map;

public class IDCardFactory extends Factory {
    private int serial = 100; // 정수 기본 데이터 타입
    private Map<Integer, String> database = new HashMap<>(); // 정수 객체

    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++); // 시리얼 넘버는 100부터 1씩 증가
    }

    @Override
    protected void registerProduct(Product product) {
        database.put(product.getSerial(), ((IDCard) product).getOwner()); // serial을 키로, owner를 값으로 저장
        System.out.println(product + "을 등록했습니다.");
    }

    public String getOwner(int serial) {
        return database.get(serial);
    }

    public Map<Integer, String> getDatabase() {
        return database;
    }
}
