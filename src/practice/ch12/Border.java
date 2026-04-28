package practice.ch12;

// 장식자를 대표하는 클래스: 장식자의 특징: 장식 대상을 장식해야 함
public abstract class Border extends Display {
    // 이 장식틀이 감싸는 장식 대상(내용물): Display는 부모 타입이므로 밑에 있는 모든 것은 장식 가능
    protected Display display; 

    protected Border(Display display) { // 인스턴스 생성 시 '내용물'을 인수로 지정
        this.display = display;
    }
}
