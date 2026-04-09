package practice.ch10;

public class Player {
    private String name;
    private Strategy strategy; // 중요 - 부모 타입인 Player는 모든 종류의 자식 전략 객체를 가리킬 수 있다 -> 교체가 쉽다 => 다형성 (다이어그램상 마름모로 표현됨)
    private int wincount;
    private int losecount;
    private int gamecount;

    // 이름과 전략을 받아서 플레이어를 만든다 
    public Player(String name, Strategy strategy) { // 부모 타입이므로 모든 전략 객체 받을 수 있음
        this.name = name;
        this.strategy = strategy;
    }

    // 전략에 따라 다음 손을 결정한다
    public Hand nextHand() {
        return strategy.nextHand(); // 중요 핵심 - 전략 객체에게 위임함!!
    }

    // 승리
    public void win() {
        strategy.study(true);
        wincount++;
        gamecount++;
    }

    // 패배
    public void lose() {
        strategy.study(false);
        losecount++;
        gamecount++;
    }

    // 무승부 
    public void even() {
        gamecount++;
    }

    @Override
    public String toString() {
        return "["
            + name + ":"
            + gamecount + " games, "
            + wincount + " win, "
            + losecount + " lose"
            + "]";
    }
}
