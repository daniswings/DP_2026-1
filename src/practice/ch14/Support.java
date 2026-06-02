package practice.ch14;

public abstract class Support { // 다른 서포트들의 부모, 추상 클래스
    private String name;    // 이 트러블 해결자 이름
    // 중요 - 떠넘길 곳 (Support: 부모 타입이므로 모든 종류의 해결자들을 가리킬 수 o)
    private Support next;

    public Support(String name) {
        this.name = name;
        this.next = null;
    }

    // 떠넘길 곳을 설정한다
    // 인자 타입은 부모 타입
    public Support setNext(Support next) {
        this.next = next;
        return next; // 인자로 들어온 뒷사람을 반환함
    }

    // 트러블 해결 절차를 결정한다 - 템플릿 메소드가 적용된 메소드
    public void support(Trouble trouble) {
        if (resolve(trouble)) { // 내가 해결을 시도
            done(trouble); // 성공 시 해결했다고 선언
        } else if (next != null) { // 내가 해결 못 하고 뒷사람이 있으면
            next.support(trouble); // 중요 - 뒷사람에게 떠넘김
        } else { // 내가 해결 못 하고 뒷사람도 없으면
            fail(trouble); // 해결 못 했다고 선언
        }
    }

    // 트러블 해결자의 문자열 표현
    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // 해결하려고 한다
    // 자식들이 해결 방법을 구현(결정)함
    protected abstract boolean resolve(Trouble trouble);

    // 해결했다 
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    // 해결되지 않았다 
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
