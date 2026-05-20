package hw.ch16;

import ch16.Sample.Colleague;
import ch16.Sample.Mediator;
import java.awt.Color;
import java.awt.Label;

public class ColleagueLabel extends Label implements Colleague {
    private Mediator mediator;

    public ColleagueLabel(String text) {
        super(text);
    }

    // Mediator를 설정
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator가 활성/비활성을 지시할 때 호출됨 -> 텍스트 & 색상 변경
    @Override
    public void setColleagueEnabled(boolean enabled) {
        if (enabled) {
            setText(" 로그인 가능");
            setForeground(Color.blue);  // 활성화 시 파란색
        } else {
            setText(" 로그인 불가");
            setForeground(Color.gray);  // 비활성화 시 회색
        }
    }
}