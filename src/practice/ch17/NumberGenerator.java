package practice.ch17;

import java.util.ArrayList;
import java.util.List;

// 관찰 대상: 자기 상태가 바뀌면 관찰자에게 통지하고, 관찰자를 관리하는 역할
public abstract class NumberGenerator {
    // Observer를 저장한다  
    // Observer라는 타입은 부모 타입 -> 모든 종류의 관찰자들을 저장할 수 있다
    // 알아두기 - 관찰 대상은 구체적으로 어떤 종류의 관찰자인지 모르고, 알 필요도 없음!
    // ㄴ => 관찰자와 관찰 대상이 느슨한 결합을 갖고 있다
    // 느슨한 결합 = 서로 독립적으로 존재하며 필요할 때만 결합 -> 상호 의존도가 낮으므로 좋은 의미
    private List<Observer> observers = new ArrayList<>();

    // Observer를 추가한다 
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Observer를 제거한다 
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // Observer에 통지한다 - 가장 중요!
    // cf) : 기준 왼쪽은 타입, 오른쪽은 집합체
    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(this); // 관찰자에게 통지 (this는 NumberGenerator 자신)
        }
    }

    // 수를 취득한다 
    public abstract int getNumber();

    // 수를 생성한다 
    public abstract void execute();
}
