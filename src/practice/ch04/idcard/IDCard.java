package practice.ch04.idcard;

import practice.ch04.framework.Product;

public class IDCard extends Product { // Product를 상속받음
    private String owner;

    public IDCard(String owner) { // IDCard(String owner) {}만 작성 시 같은 패키지 내에서만 사용 가능 -> public 필요
        System.out.println(owner + "의 카드를 만듭니다."); // 문자열 + 문자열 출력
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this.toString() + "을 사용합니다."); // 객체 + 문자열 형태이므로 객체인 this를 문자열로 바꿔주기 위해 this.toString()이 호출되도록
    }

    @Override
    // Object 클래스의 toString 메소드 오버라이드
    public String toString() {
        return "[IDCard:" + owner + "]";
    }

    public String getOwner() {
        return owner;
    }
}
