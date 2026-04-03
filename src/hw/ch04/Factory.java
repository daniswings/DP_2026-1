package hw.ch04;

public abstract class Factory {
    // 템플릿 메소드: 객체 생성의 전체적 흐름 결정
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    // 하위 클래스에서 구체적으로 구현할 추상 메서드들
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
