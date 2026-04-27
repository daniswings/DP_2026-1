package practice.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    // directory: 자식들을 보관하는 리스트. Entry는 부모 타입 - 디렉터리와 파일 모두 담을 수 있다
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() { // 모든 자식의 크기를 더함
        int size = 0; // 꼭 초기화 필요
        for (Entry entry: directory) { // 형식 - (원소 변수: 컬렉션)으로 구성됨
            // 세 줄 위에서 getSize 호출했는데 여기서 또 호출됨 -> 이것이 바로 재귀적 호출임
            size += entry.getSize(); 
            // 꺼내온 애가 또 directory면 그 안에 또 자식이 있을 수 있기 때문에 getSize가 또 호출됨
        }
        return size;
    }

    @Override
    protected void printList(String prefix) { // 이 디렉터리의 이전 경로(이 앞까지의 경로)가 넘어오면
        System.out.println(prefix + "/" + this); // 일단 자기 거 출력
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name); // 이 폴더까지 포함한 경로
        }
    }

    // 디렉터리 엔트리를 디렉터리에 추가한다
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}
