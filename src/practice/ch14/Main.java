package practice.ch14;

public class Main {
    public static void main(String[] args) {
        // 해결자들 생성
        Support alice = new NoSupport("Alice");
        // 100 이하는 bob이 해결
        Support bob = new LimitSupport("Bob", 100);
        // 429인 숫자만 charlie가 해결
        Support charlie = new SpecialSupport("Charlie", 429);
        // 홀수 번호는 diana가 해결
        Support diana = new OddSupport("Diana");

        // 사슬 형성
        // alice.setNext(bob)의 return 값은 bob이므로, 바로 뒤에 .setNext(charlie)로 덧붙여 연결 가능
        alice.setNext(bob).setNext(charlie).setNext(diana);

        // 문제를 첫 번째 객체에게 던져준다
        // 괄호 안에 어떤 숫자가 들어가냐에 따라 해결자가 달라진다
        // e.g. 429는 charlie만, 99는 bob과 diana가 해결 가능(근데 bob이 더 앞이라 bob이 해결)
        // 150은 bob이 해결 가능. 1000은 아무도 해결 불가능
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }
    }
}
