package practice.ch22;

import practice.ch22.command.*;
import practice.ch22.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
    // 그리기 이력 
    private MacroCommand history = new MacroCommand();
    // 그리는 영역 
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼
    private JButton clearButton  = new JButton("clear");

    // 생성자 
    public Main(String title) {
        super(title);

        this.addWindowListener(this); // 버튼 눌렀을 때 동작
        canvas.addMouseMotionListener(this); // mouseMoved, mouseDragged 두 개 구현해줘야 함
        clearButton.addActionListener(e -> { // 이벤트 발생 시 
            history.clear(); // history (이력 전체)를 삭제하고 
            canvas.repaint(); // 캔버스를 다시 그림 -> paint()가 호출됨 -> history.execute()가 호출됨 -> 아무것
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    // MouseMotionListener용
    @Override
    // 캔버스 위에서 마우스가 움직일 때마다 일을 함
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouseMoved: " + e.getPoint());
    }

    // 커맨드 패턴의 핵심 - 명령어 객체 DrawCommand 객체를 execute로 실행한다
    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint()); //그리기 명령 객체가 생성됨
        history.append(cmd); // 그리기 명령이 이력에 추가됨
        cmd.execute(); // 그리기 명령을 실행함
    }

    // WindowListener용 
    @Override
    // windowClosing 하나만 구현해주면 익명의 내부 클래스가 만들어짐 -> 코드가 훨씬 간략해짐
    public void windowClosing(WindowEvent e) {
        System.exit(0); // 종료시킴
    }

    // 하는 일이 없어도 WindowLister를 구현해야 하므로 빈칸 { }로 놔둠
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
