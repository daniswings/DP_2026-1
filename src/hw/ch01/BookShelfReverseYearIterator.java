package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfReverseYearIterator implements Iterator<Book> {
    private Book[] sortedBooks;
    private int index;

    public BookShelfReverseYearIterator(BookShelf bookShelf) {
        int size = bookShelf.getLength();
        this.sortedBooks = new Book[size];

        // 1. 책꽂이의 책들 -> 새로운 배열로 그대로 복사
        for (int i = 0; i < size; i++) {
            sortedBooks[i] = bookShelf.getBookAt(i);
        }

        // 2. 출판연도 내림차순(최신순) 정렬 by using 버블 정렬
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                // 뒤에 있는 책의 연도가 더 크면 자리 바꿈
                if (sortedBooks[j].getYear() < sortedBooks[j + 1].getYear()) {
                    Book temp = sortedBooks[j];
                    sortedBooks[j] = sortedBooks[j + 1];
                    sortedBooks[j + 1] = temp;
                }
            }
        }
        
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < sortedBooks.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = sortedBooks[index];
        index++;
        return book;
    }
}