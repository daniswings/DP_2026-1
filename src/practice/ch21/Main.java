package practice.ch21;

public class Main {
    public static void main(String[] args) {
        //  본인 생성 - 실행 시 5초 소요(5초 기다렸다가 생성됨)
        //Printable p1 = new Printer("Alice"); 
        //p1.print("Hello, world!");

        // 프록시를 생성해서 이용해보려면 위 두 줄 주석처리 필요
        Printable p2 = new PrinterProxy(); // 프록시 생성 - 즉시 생성됨
        p2.setPrinterName("Bob"); // 프록시한테 이름 설정 - 즉시 설정됨
        System.out.println(p2.getPrinterName()); // 프록시한테 이름 취득 - 즉시 취득됨

        p2.print("Hello, world!"); // 프록시한테 표시 요청 - 이 때 본인이 생성됨

    }
}
