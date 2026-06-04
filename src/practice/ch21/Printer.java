package practice.ch21;
public class Printer implements Printable {
    private String name; // 이름 

    // 생성자 
    // 본인 - 특징: 생성될 때 시간이 오래 걸림(heavyJob() 메서드 호출하기 때문)
    public Printer() {
        heavyJob("Printer 인스턴스 생성 중");
    }

    // 생성자(이름 지정)
    public Printer(String name) {
        this.name = name;
        heavyJob("Printer 인스턴스(" + name + ") 생성 중");
    }

    // 이름 설정 
    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    // 이름 취득 (이름을 리턴하는 메서드)
    @Override
    public String getPrinterName() {
        return name;
    }

    // 이름 붙여서 표시
    @Override
    public void print(String string) {
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    // 무거운 작업이라고 가정
    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) { // 3. 5번 반복
            try {
                Thread.sleep(1000); // 1. 1초 쉬고
            } catch (InterruptedException e) {
            }
            System.out.print("."); // 2. 점 찍는 동작
        }
        System.out.println("완료"); // 4. 완료 메시지 출력
    }
}
