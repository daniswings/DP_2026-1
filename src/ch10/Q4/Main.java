package ch10.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서(오름차순)
        list.sort( /* 미구현 */ ); // 이 괄호 안에 비교기가 뭐가 들어오냐에 따라 결과 달라짐 -> 얘를 전략이라고할 수 있음
        System.out.println(list);

        // 사전순으로 큰 순서(내림차순)
        list.sort( /* 미구현 */ );
        System.out.println(list);
    }
}
