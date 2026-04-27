package practice.ch02.delegation;

public class Main {
    public static void main(String[] args) {
        Print print = new PrintBannerAdapter02("Hello, World!");
        print.printWeak(); 
        print.printStrong();

        // 형 변환(타입캐스팅) - 부모 타입으로 선언했지만 꼭 자식이 제공하는 특정 메소드 호출 원하면 형 변환을 통해 가능
        ((PrintBannerAdapter02)print).getYourName();
        // (PrintBannerAdapter02)print에 괄호를 한 번 더 씌워야만 
        // print.getYourName을 한 후 PrintBannerAdapter02를 형 변환하여 순서가 맞음
    }
}
