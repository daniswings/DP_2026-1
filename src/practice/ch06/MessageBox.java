package practice.ch06;

import practice.ch06.framework.Product;

public class MessageBox implements Product {
    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int decolen = 1 + s.length() + 1;
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar);
        }
        System.out.println();
        System.out.println(decochar + s + decochar);
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product p = null;
        try {
            // 자기 복제 메소드, 만약 Product 없다면 Object타입이므로 Product 넣어 형변환 필요
            p = (Product)clone(); 
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
