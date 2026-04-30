package hw.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry: directory) {
            size += entry.getSize();
        }
        return size;
    }

    // Composite 노드 Directory의 search 로직 (재귀 및 병합)
    @Override
    public List<Entry> search(String keyword) {
        List<Entry> result = new ArrayList<>();
        // 1. 자기 자신의 이름에 keyword 있는지 검사
        if (name.contains(keyword)) {
            result.add(this);
        }
        // 2. 내용물(=자식들)을 재귀적으로 탐색해 addAll로 결과 병합
        for (Entry entry : directory) {
            result.addAll(entry.search(keyword));
        }
        return result;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    public Entry add(Entry entry) {
        directory.add(entry);
        entry.setParent(this);
        return this;
    }
}