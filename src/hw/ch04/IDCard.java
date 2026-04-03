package hw.ch04;

public class IDCard extends Product {
    private String owner;
    private int serial;
    private String issuedDate; // 필드 추가: String issuedDate

    // 생성자 수정: IDCard(String owner, int serial, String issuedDate 추가)
    IDCard(String owner, int serial, String issuedDate) {
        System.out.println(owner + "의 카드를 " + serial + "번으로 만듭니다.");
        this.owner = owner;
        this.serial = serial;
        this.issuedDate = issuedDate;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() { // 발급 날짜 포함해 출력하도록 toString() 메서드 수정
        return "[IDCard:" + owner + " (" + serial + ")] - 발급일: " + issuedDate;    }

    public String getOwner() {
        return owner;
    }

    // getter 메서드 getIssuedDate() 추가해 발급 날짜 가져옴
    public String getIssuedDate() {
        return issuedDate;
    }
}
