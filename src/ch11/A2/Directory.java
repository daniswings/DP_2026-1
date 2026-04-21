package ch11.A2;

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

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    // 핵심
    public Entry add(Entry entry) { // (Entry entry)는 부모 - 자식 순
        directory.add(entry);
        entry.setParent(this); // 자식 엔트리에게 부모(즉 현재 디렉토리)를 설정 
        return this;
    }
}
