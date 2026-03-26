package practice.ch04.framework;

public abstract class Factory {

    // 이 메소드가 템플릿 메소드, 즉 제품 생산하는 방식을 정의하는 메소드
    public final Product create(String owner) {
        Product p = createProduct(owner); // 실제 제품 생산
        registerProduct(p); // 생산된 제품을 등록
        return p;
    }
    // 팩토리 메소드 - 추상 클래스를 실제로 구성하는 메소드
    protected abstract Product createProduct(String owner); // 어떤 제품 생산할지는 자식들이 결정
    protected abstract void registerProduct(Product product);
}
