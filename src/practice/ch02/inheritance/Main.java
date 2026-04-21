package practice.ch02.inheritance;

public class Main {
    public static void main(String[] args) {
        Banner banner = new Banner("Hello, world!");
        banner.showWithParen();
        banner.showWithAster();

        System.out.println("어댑터 이용");
        Print print = new PrintBannerAdapter01("Hellow, World!");
        print.printWeak();
        print.printStrong();

    }
}
