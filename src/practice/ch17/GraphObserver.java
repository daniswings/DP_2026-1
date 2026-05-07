package practice.ch17;

// 관찰자
public class GraphObserver implements Observer {
    @Override
    // 통지받을 때 호출되는 메소드
    public void update(NumberGenerator generator) {
        // println 아닌 print이므로 줄 안 바꾸고 graphobserver 출력
        System.out.print("GraphObserver:");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
