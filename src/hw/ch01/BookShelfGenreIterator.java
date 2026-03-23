package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfGenreIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;
    private String targetGenre; // 내가 찾고자 하는 장르

    public BookShelfGenreIterator(BookShelf bookShelf, String targetGenre) {
        this.bookShelf = bookShelf;
        this.index = 0;
        this.targetGenre = targetGenre;
    }

    @Override
    public boolean hasNext() {
        // 현재 인덱스부터 끝까지 돌면서 타겟 장르와 일치하는 책이 있는지 확인
        while (index < bookShelf.getLength()) {
            Book book = bookShelf.getBookAt(index);

            // 장르가 일치 -> 여기서 멈추고 return true (index는 그 책을 가리킨 상태로 대기)
            if (targetGenre.equals(book.getGenre())) {
                return true;
            }
            index++; // if not 일치 -> 다음 책으로 넘어감
        }
        return false;
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        // hasNext() 덕에 현재 index는 무조건 타겟 장르의 책을 가리킴
        Book book = bookShelf.getBookAt(index);
        index++; // 책을 꺼냈으니 -> 다음 책 찾기 위해 인덱스++
        return book;
    }
}