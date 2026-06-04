package practice.ch21;

public class PrinterProxy implements Printable {
    private String name;	// 이름
    // 프락시는 '본인'을 가리키는 속성 필요 (그래야 필요 시 본인 생성 가능)
    private Printer real;	

    // 생성자 
    public PrinterProxy() {
        this.name = "No Name";
        this.real = null;
    }

    // 생성자(이름 지정)
    public PrinterProxy(String name) {
        this.name = name;
        this.real = null;
    }

    // 이름 설정 
    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) { // '본인'이 이미 생성되어 있다면
            // '본인'에게도 이름을 설정해줘야 함
            real.setPrinterName(name);
        }
        this.name = name; // 본인이 없다면 자기만 이름 설정해줘도 됨
    }

    // 이름 취득 
    @Override
    public String getPrinterName() {
        return name;
    }

    // 표시 
    // 대리인이 할 수 없는 일
    @Override
    public void print(String string) {
        realize(); // 아래 realize()로 호출 - 본인을 생성함
        real.print(string); // 본인한테 위임
    }

    // 본인 생성 
    private synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }
}
