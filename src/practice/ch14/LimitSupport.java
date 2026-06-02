package practice.ch14;

public class LimitSupport extends Support {
    private int limit; // 이 번호 미만이면 해결할 수 있다

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        } else {
             // 무조건 false 반환 - limit 번호 이상의 트러블은 해결할 수 없다
            return false;
        }
    }
}
