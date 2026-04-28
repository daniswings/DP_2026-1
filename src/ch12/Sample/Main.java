package ch12.Sample;

public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, world."); // 중심
        Display b2 = new SideBorder(b1, '#'); // 장식자1
        Display b3 = new FullBorder(b2); // 장식자2
        // b1을 sideborder로 장식한 결과물이 도 b2로 장식하는 장식 대상이 된다
        b1.show();
        b2.show();
        b3.show();
        Display b4 =
                    new SideBorder(
                        new FullBorder(
                            new FullBorder(
                                new SideBorder(
                                    new FullBorder(
                                        new StringDisplay("Hello, world.") // 중심
                                    ),
                                    '*'
                                )
                            )
                        ),
                        '/'
                    );
        b4.show();
    }
}
