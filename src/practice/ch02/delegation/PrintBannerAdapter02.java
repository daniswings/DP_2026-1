package practice.ch02.delegation;

// 추상 클래스는 implements로 안 되고 상속 받아야 하므로 extends 사용
// 자바에서는 다중 상속이 불가능(즉, 부모가 둘 이상은 허용 안 됨) -> 나머지 Banner는 위임을 이용
public class PrintBannerAdapter02 extends Print{
    private Banner banner; // Banner 클래스의 인스턴스를 참조하는 필드

    public PrintBannerAdapter02(String text) {
        this.banner = new Banner(text); // Banner 클래스의 인스턴스를 생성하여 필드에 할당
    }

    @Override
    public void printWeak() {
        banner.showWithParen(); // Banner 클래스의 메서드를 호출하여 기능을 수행 (Main에서 printWeak 호출 시 printWeak는 Banner에게 위임)
    }

    @Override
    public void printStrong() {
        banner.showWithAster(); // Banner 클래스의 메서드를 호출하여 기능을 수행(위임))
    }

    public String getYourName() {
        return "홍길동";
    }
}
