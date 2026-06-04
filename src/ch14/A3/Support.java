package ch14.A3;

public abstract class Support {
    private String name;    // 이 트러블 해결자의 이름
    private Support next;   // 떠넘길 곳

    public Support(String name) {
        this.name = name;
        this.next = null;
    }

    // 떠넘길 곳을 설정한다
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    // 트러블 해결 절차를 결정한다 
    public void support(Trouble trouble) {
        // 핵심: 루프 한 번 돌 때마다 obj.next로 obj가 바뀜
        // 재귀적으로 호출되던 게 for 루프로도 가능
        for (Support obj = this; true; obj = obj.next) {
            if (obj.resolve(trouble)) {
                obj.done(trouble);
                break; // 해결이 되면 루프를 빠져나간다
            } else if (obj.next == null) { // 뒷사람(해결자)가 없으면
                obj.fail(trouble); // 실패
                break; // 실패했어도 루프를 빠져나감
            }
        }
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // 해결하려고 한다 
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

