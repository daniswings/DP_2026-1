package ch15.Sample.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// 퍼사드 역할을 하는 클래스 - 클라이언트인 Main이 요청 시 Facade인 PageMaker가 대신 만듦
public class PageMaker {
    // 생성자가 private이므로 외부에서 인스턴스를 생성 불가
    private PageMaker() {
    }

    // High Level API
    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title(username + "'s web page");
            writer.paragraph("Welcome to " + username + "'s web page!");
            writer.paragraph("Nice to meet you!");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
