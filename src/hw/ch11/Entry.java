package hw.ch11;

import java.util.List;

public abstract class Entry {
    private Entry parent;

    protected void setParent(Entry parent) { // 부모 설정
        this.parent = parent;
    }

    public abstract String getName(); // 이름 가져옴
    public abstract int getSize(); // 크기 가져옴
    // search 추상 메서드 추가 - 모든 파일 & 디렉터리가 공통으로 가져야 하는 메서드
    public abstract List<Entry> search(String keyword);

    public void printList() { // 목록 표시
        printList("");
    }

    protected abstract void printList(String prefix); // prefix를 앞에 붙여 목록 표시

    // 문자열 표시
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

    // 전체 경로 가져옴 
    public String getFullName() {
        StringBuilder fullname = new StringBuilder();
        Entry entry = this;
        
        do {
            fullname.insert(0, entry.getName());
            fullname.insert(0, "/");
            entry = entry.parent;
        } while (entry != null);

        return fullname.toString();
    }
}