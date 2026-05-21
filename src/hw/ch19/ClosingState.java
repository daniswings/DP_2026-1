package hw.ch19;

import ch19.A4.Context;
import ch19.A4.State;
import ch19.A4.DayState;
import ch19.A4.NightState;
import ch19.A4.UrgentState;

public class ClosingState implements State {
    // 인스턴스를 하나만 생성하는 Singleton 패턴
    private static ClosingState singleton = new ClosingState();

    private ClosingState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        // 시간 조건에 따라 상태 전환
        if (hour < 17) {
            context.changeState(DayState.getInstance());
        } else if (20 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        // 마감 금고 점검은 'call!'로 출력되어야 하므로 -> callSecurityCenter 사용
        context.callSecurityCenter("마감 금고 점검");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(마감)");
        // 비상벨 울리면 무조건 UrgentState로 상태 전환
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        // 퇴근 확인 통화는 'record ...'로 출력되어야 하므로 -> recordLog 사용
        context.recordLog("퇴근 확인 통화(마감)");
    }

    @Override
    public String toString() {
        return "[마감]";
    }
}