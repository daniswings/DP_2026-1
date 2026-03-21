package hw.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("[학번: 20240974 | 이름: 박다인] - SW 분석 및 설계 과제 1장\n");

        // [4-1]
        BookShelf bookShelf = new BookShelf(10);
        
        bookShelf.appendBook(new Book("클린코드", "기술", 2008, 30000));
        bookShelf.appendBook(new Book("해리포터와 마법사의 돌", "소설", 1997, 15000));
        bookShelf.appendBook(new Book("사피엔스", "역사", 2011, 18000));
        bookShelf.appendBook(new Book("이펙티브 자바", "기술", 2018, 36000));
        bookShelf.appendBook(new Book("객체지향의 사실과 오해", "기술", 2015, 20000));
        bookShelf.appendBook(new Book("레미제라블", "소설", 1862, 12000));
        bookShelf.appendBook(new Book("총균쇠", "역사", 1997, 22000));
        bookShelf.appendBook(new Book("리팩터링", "기술", 2018, 34000));
        bookShelf.appendBook(new Book("로마인 이야기", "역사", 1992, 25000));
        bookShelf.appendBook(new Book("어린왕자", "소설", 1943, 9000));

        // [4-2] 장르 필터 Iterator를 테스트 ('소설' 장르만 출력되도록!!)
        System.out.println("===== [4-2] 장르 필터 테스트 (소설 only) =====");
        Iterator<Book> genreIt = bookShelf.iteratorByGenre("소설");
        while (genreIt.hasNext()) {
            Book book = genreIt.next();
            System.out.println("제목: " + book.getName() + " | 장르: " + book.getGenre() + " | 출판연도: " + book.getYear() + "년 | 가격: " + book.getPrice() + "원");
        }
        System.out.println(); // just for 줄바꿈

        // [4-3] 출판연도 역순 iterator를 테스트 (최신순)
        System.out.println("===== [4-3] 출판연도 역순 테스트 (최신 책부터 출력됨) =====");
        Iterator<Book> yearIt = bookShelf.iteratorByYear();
        while (yearIt.hasNext()) {
            Book book = yearIt.next();
            System.out.println("제목: " + book.getName() + " | 장르: " + book.getGenre() + " | 출판연도: " + book.getYear() + "년 | 가격: " + book.getPrice() + "원");
        }
    }
}