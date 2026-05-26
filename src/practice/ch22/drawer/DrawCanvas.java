package practice.ch22.drawer;

import practice.ch22.command.MacroCommand;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DrawCanvas extends Canvas implements Drawable {
    // 그리는 색 
    // Color라는 클래스에 빨간색을 나타내는 상수 red를 담아둠
    private Color color = Color.red;
    // 그리는 점의 반지름 
    private int radius = 6;
    // 이력
    // 중요 - 지금까지의 그리기 명령들을 모아놓은 곳
    private MacroCommand history;

    // 생성자 
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    // 이력 전체 다시 그리기 
    @Override
    // repaint()가 호출될 때마다 이 메소드가 호출됨
    public void paint(Graphics g) { 
        history.execute();
    }

    // 그리기 
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        // fillOval은 원 채우는 메소드
        // 4개의 인자 중 앞 2개는 원이 그려질 좌표, 뒤 2개는 그 좌표로부터의 가로세로
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
