package practice.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;

// 명령어 묶음이면서 하나의 명령
public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>();

    // 실행 
    @Override
    public void execute() {
        for (Command cmd: commands) {
            cmd.execute(); // 리커시브 호출(execute()호출 시 자기가 가지고 있는 커맨드 다 꺼내서 호출..??)
        }
    }

    // 추가 - deque에 push
    public void append(Command cmd) {
        if (cmd == this) { // 같은 거에 같은 거 넣었을 때 오류 메세지 출력
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // 마지막 명령을 삭제 - 꺼내올 땐 pop 사용
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();
    }
}
