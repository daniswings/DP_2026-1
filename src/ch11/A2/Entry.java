package ch11.A2;

public abstract class Entry {
    private Entry parent;

    // 부모를 설정한다
    protected void setParent(Entry parent) {
        this.parent = parent;
    }

    // 이름을 가져온다 
    public abstract String getName();

    // 크기를 가져온다 
    public abstract int getSize();

    // 목록을 표시한다 
    public void printList() {
        printList("");
    }

    // prefix를 앞에 붙여 목록을 표시한다
    protected abstract void printList(String prefix);

    // 문자열 표시
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

    // 전체 경로를 가져온다 
    public String getFullName() {
        StringBuilder fullname = new StringBuilder(); // 전체 경로를 저장할 StringBuilder 객체 생성
        Entry entry = this;
        
        // 여기가 핵심!
        do {
            fullname.insert(0, entry.getName()); // 0번 위치에 현재 이름, 예를 들면 교안의 Composite.java를 넣음 -> Composite.java
            fullname.insert(0, "/"); // 현재 Composite.java 앞에 / 넣음 -> /Composite.java
            entry = entry.parent; // 부모로 이동 (현재 엔트리의 부모를 다시 entry에 할당) -> Composite.java의 부모는 youngjin 디렉토리 -> /youngjin/Composite.java (=트리의 윗방향으로 이동)
        } while (entry != null);

        return fullname.toString();
    }
}
