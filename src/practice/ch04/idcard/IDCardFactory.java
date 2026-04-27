package practice.ch04.idcard;

import practice.ch04.framework.Factory;
import practice.ch04.framework.Product;

public class IDCardFactory extends Factory {
    @Override
    // 중요! 부모 타입은 자식 객체를 참조할 수 있다 (가리킬 수 있다.) 
    // -> 부모 타입으로 받는다면 부모 타입이든 자식 타입이든 => 다형성
    
    // 부모 객체는 자식 타입이 참조할 수 없다 -> 따라서 부모 타입 사용 시 좀 더 유연하게 사용 가능
    protected Product createProduct(String owner) {
        // IDCard를 만드는 것이므로 윗줄도 protected IDCard가 되어야 할 것 같지만
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) { // 제품을 등록하는 메서드
        // 문자열 + 문자열 형태, toString()이 호출되도록(생략 가능)
        System.out.println(product.toString() + "을 등록했습니다."); 
    }
}
