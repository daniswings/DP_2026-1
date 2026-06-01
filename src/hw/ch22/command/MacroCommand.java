package hw.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>();
    // Undo 시 삭제된 명령을 임시 보관하는 Deque (for Redo)
    private Deque<Command> commandsForRedo = new ArrayDeque<>();

    // 실행 
    @Override
    public void execute() {
        // [요구사항 Step 4] 꼬리부터 순서대로 실행하도록 descendingIterator 사용
        Iterator<Command> it = commands.descendingIterator();
        while (it.hasNext()) {
            it.next().execute();
        }
    }

    // 추가 
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
        // 새로운 명령 추가되면 -> Redo 이력은 날려야 함
        commandsForRedo.clear();
    }

    // 마지막 명령 삭제 (Undo)
    public void undo() {
        if (!commands.isEmpty()) {
            // 최근 명령 꺼내서 commandsForRedo에 보관
            Command cmd = commands.pop();
            commandsForRedo.push(cmd);
        }
    }

    // 취소된 명령 다시 실행 (Redo)
    public void redo() {
        if (!commandsForRedo.isEmpty()) {
            Command cmd = commandsForRedo.pop();
            commands.push(cmd);
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();
        // Clear 시 commandsForRedo도 함께 비움
        commandsForRedo.clear();
    }
}