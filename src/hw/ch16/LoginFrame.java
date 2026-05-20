package hw.ch16;

import ch16.Sample.*;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;
    
    // 하단에 상태 표시한 라벨 추가
    private ColleagueLabel statusLabel; 

    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);

        // 라벨이 들어갈 자리 위해 5x2 그리드로 확장
        setLayout(new GridLayout(5, 2));

        createColleagues();

        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        
        // 마지막 5번째 행에 statusLabel과 빈 칸 추가
        add(statusLabel); 
        add(new Label("")); 

        colleagueChanged();

        pack();
        setVisible(true);
    }

    @Override
    public void createColleagues() {
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);

        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');

        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");
        
        // statusLabel 초기화 (초기 텍스트: 로그인 불가)
        statusLabel = new ColleagueLabel(" 로그인 불가");

        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);
        statusLabel.setMediator(this); // Label도 Mediator 설정 필수!

        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
            // 게스트 모드 - 조건 x 로그인 가능 -> 라벨도 바로 true 설정
            statusLabel.setColleagueEnabled(true);
        } else {
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    // 아이디나 비번 변경 시 호출 -> 활성/비활성 판정
    private void userpassChanged() {
        // Username과 Password 모두 4자 이상일 때만 로그인 가능
        if (textUser.getText().length() >= 4) { 
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() >= 4) { 
                buttonOk.setColleagueEnabled(true);
                statusLabel.setColleagueEnabled(true); // 조건 만족 시 파란색
            } else {
                buttonOk.setColleagueEnabled(false);
                statusLabel.setColleagueEnabled(false); // 불만족 시 회색
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
            statusLabel.setColleagueEnabled(false); // 불만족 시 회색
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}