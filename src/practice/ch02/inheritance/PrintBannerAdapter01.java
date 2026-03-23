package practice.ch02.inheritance;

// 클라이언트가 원하는 인터페이스를 구현한 어댑터 클래스
public class PrintBannerAdapter01 extends Banner implements Print {
    // (1) 인자 없는 생성자는 자동으로 생성됨 (따라서 호출 가능)
    // (2) 생성자는 상속되지 않음 (-> 따라서 아래 PrintBannerAdapter01처럼 구현 필요 )

    public PrintBannerAdapter01(String text){
        super(text); // 부모 생성자를 호출한다는 의미
    }

    @Override
    public void printWeak() {
        showWithParen(); // 앞에 this. 생략
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
    
}
