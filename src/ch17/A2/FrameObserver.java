package ch17.A2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// observer == 관찰자 역할, actionListener == 버튼이 눌렸을 때의 이벤트 처리 역할
public class FrameObserver extends Frame implements Observer, ActionListener {
    // GraphText는 통지된 수를 텍스트 필드로 표시하는 static 클래스 
    static class GraphText extends TextField implements Observer {
        public GraphText(int columns) {
            super(columns);
        }

        @Override
        public void update(NumberGenerator generator) {
            int number = generator.getNumber();
            String text = number + ":";
            for (int i = 0; i < number; i++) {
                text += '*';
            }
            setText(text);
        }
    }

    // GraphCanvas는 통지된 수를 원그래프로 표시하는 static 클래스 
    static class GraphCanvas extends Canvas implements Observer {
        private int number;

        @Override
        public void update(NumberGenerator generator) { // 이 관찰자가 하는 일
            number = generator.getNumber();
            repaint(); // repaint()는 도화지를 클리어하고 paint() 메소드를 호출한다
        }

        public void paint(Graphics g) { // Graphics는 그림을 그리는 역할 & 색 정보 등 가짐
            int width = getWidth();
            int height = getHeight();

            // 흰색 원
            g.setColor(Color.white);
            //fillArc는 인자가 6개(뒤에 두 개가 중요) / 0도부터 360도까지의 원을 그린다
            g.fillArc(0, 0, width, height, 0, 360);

            // 빨간색 원호
            g.setColor(Color.red);
            g.fillArc(0, 0, width, height, 90, - number * 360 / 50); // Arc = 원호
        }
    }

    private GraphText textGraph = new GraphText(60);
    private GraphCanvas canvasGraph = new GraphCanvas();
    private Button buttonClose = new Button("Close");

    public FrameObserver() {
        super("FrameObserver");
        // setLayout에 BorderLayout을 넣어 북쪽, 중앙, 남쪽에 컴포넌트를 배치할 수 있도록 한다
        setLayout(new BorderLayout());

        setBackground(Color.lightGray);
        textGraph.setEditable(false);
        canvasGraph.setSize(500, 500);
        add(textGraph, BorderLayout.NORTH);
        add(canvasGraph, BorderLayout.CENTER);
        add(buttonClose, BorderLayout.SOUTH);
        buttonClose.addActionListener(this);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }

    @Override
    public void update(NumberGenerator generator) {
        textGraph.update(generator); // textGraph에서 업데이트 호출
        canvasGraph.update(generator); // canvasGraph에서 업데이트 호출
    }
}

