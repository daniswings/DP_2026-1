package practice.ch14;

public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
         // 무조건 false 반환 -자신은 아무것도 해결하지 않는다
        return false;
    }
}
