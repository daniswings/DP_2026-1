package hw.ch19;

import ch19.A4.SafeFrame;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번: 20240974  이름: 박다인\n");

        SafeFrame frame = new SafeFrame("State Sample");
        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);   // 시간 설정 
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}