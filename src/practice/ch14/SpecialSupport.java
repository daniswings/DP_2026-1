package practice.ch14;

public class SpecialSupport extends Support {
    private int number; // 이 번호만 해결할 수 있다

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        // 지정된 번호의 트러블만 해결할 수 있다
        if (trouble.getNumber() == number) {
            return true;
        } else {
             // 무조건 false 반환 - 지정된 번호가 아닌 트러블은 해결할 수 없다
            return false;
        }
    }
}
