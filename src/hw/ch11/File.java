package hw.ch11;

import java.util.ArrayList;
import java.util.List;

public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    // Leaf 노드인 File의 search 로직
    // - 자기 이름에 keyword 포함 시 자신(=this)을 담아 반환, 포함 x 시 빈 리스트 반환
    @Override
    public List<Entry> search(String keyword) {
        List<Entry> result = new ArrayList<>();
        if (name.contains(keyword)) {
            result.add(this);
        }
        return result;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}