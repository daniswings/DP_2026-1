package ch21.A1;

public class Main {
    public static void main(String[] args) {
        // PrinterProxy 만들 때 Printer 객체도 같이 만들어서 이름 설정까지 해주는 생성자 추가
        Printable p = new PrinterProxy("Alice", "Printer");
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
        p.setPrinterName("Bob");
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
        p.print("Hello, world.");
    }
}
