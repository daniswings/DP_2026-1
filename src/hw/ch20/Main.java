package hw.ch20;

public class Main {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        System.out.println("학번: 20240974  이름: 박다인\n");

        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        // 1212123 입력 시 사용할 색상 배열 구성
        String[] colors = {RED, BLUE, GREEN, MAGENTA, CYAN, YELLOW, BLUE};

        BigString bs;
        
        // 터미널 인자(args[0])를 받아 -> 공유 옵션(true)으로 객체 생성
        bs = new BigString(args[0], true);
        
        // 입력 문자열 길이랑 색상 배열 길이가 일치할 때만 색상 배열 적용하도록 예외 처리
        if (args[0].length() == colors.length) {
            bs.print(colors);
        } else {
            bs.print();
        }
    }
}