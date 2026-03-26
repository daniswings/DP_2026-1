package ch04.Sample.idcard;

import ch04.Sample.framework.Product;

public class IDCard extends Product {
    private String owner;

    //부모의 인자 없는 생성자를 호출함
    // super()는 생략 가능
    super("x");
    IDCard(String owner) {
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + "]";
    }

    public String getOwner() {
        return owner;
    }
}
