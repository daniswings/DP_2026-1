package practice.ch14;

public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        // 홀수 번호의 트러블만 해결할 수 있다
        if (trouble.getNumber() % 2 == 1) {
            return true;
        } else {
             // 무조건 false 반환 - 홀수 번호가 아닌 트러블은 해결할 수 없다
            return false;
        }
    }
}
