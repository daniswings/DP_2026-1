package hw.ch01; 

public class Book {
    private String name;
    // 새 필드 3개 추가
    private String genre;
    private int year;
    private double price;

    // 요구사항 1. 기존 Book(String name) 생성자를 유지하되
    public Book(String name) {
        this.name = name;
    }

    // 새 필드를 받는 생성자를 오버로딩으로 추가
    public Book(String name, String genre, int year, double price) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }

    // 요구사항 2. Setter는 만들지 않으면서 Getter 구현 
    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }
}