package ch05.A2a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Triple {
    private static Map<String,Triple> map = new HashMap<>(); // Triple 객체 3개를 저장할 Map
    static { // static == 클래스 로드될 때 실행하라
        String[] names = { "ALPHA", "BETA", "GAMMA" }; // 3개를 내보내서 (이 3개는 람다 함수에서의 input)
        Arrays.stream(names).forEach(s -> map.put(s, new Triple(s))); // <키, 값> 쌍으로 Triple 객체를 Map에 저장 / forEach로 알파,베타, 감마로 하나씩 처리
    }

    private String name;

    private Triple(String name) {
        System.out.println("The instance " + name + " is created.");
        this.name = name;
    }

    public static Triple getInstance(String name) {
        return map.get(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
