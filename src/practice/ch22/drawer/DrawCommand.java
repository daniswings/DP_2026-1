package practice.ch22.drawer;

import practice.ch22.command.Command;
import java.awt.Point;

// 그리기 명령
public class DrawCommand implements Command {
    // 그리는 대상 
    protected Drawable drawable;

    // 그리는 위치 
    // cf. Point는 JDK에서 제공하는 클래스(x,y 라는 속성 2개 가짐(교안 슬9 참고))
    private Point position;

    // 생성자 
    // (Drawable drawable, Point position) = (어떤 도화지에, 어떤 점 그릴지)
    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    // 실행
    @Override
    public void execute() {
        drawable.draw(position.x, position.y); // 이 좌표에 그려라
    }
}
