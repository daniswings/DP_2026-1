package practice.ch22.command;


// 명려을 나타내는 인터페잇
public interface Command {
    // 무언가 일을 하는 애라는 것을 나타냄
    // but 그 일이 무엇인지는 자식이 구현
    public abstract void execute();
}
