package practice.ch06.framework;

import java.util.HashMap;
import java.util.Map;


// Product를 등록하고, 필요할 때마다 복제해서 제공하는 클래스
public class Manager {
     // Product: 부모 타입
    private Map<String,Product> showcase = new HashMap<>(); // 속성 showcase의 자료형 HashMap (해쉬맵은 키와 밸류 쌍으로 등록)

    public void register(String name, Product prototype) {
        showcase.put(name, prototype); // (key, value) 쌍으로 저장하는 Map
    }

    public Product create(String prototypeName) {
        Product p = showcase.get(prototypeName); // (key)에 해당하는 value를 반환
        return p.createCopy(); // 복제해서 반환 - 이 줄이 중요한 부분!!
    }
}
