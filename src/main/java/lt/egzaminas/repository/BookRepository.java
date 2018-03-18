package lt.egzaminas.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import lt.egzaminas.model.Institution;
import lt.egzaminas.model.NewBook;
import lt.egzaminas.model.Book;

@Repository
public class BookRepository {

    private final List<Book> books;
    private final AtomicLong idGenerator = new AtomicLong(0);

    public BookRepository() {
        books = Collections.synchronizedList(new ArrayList<>());

        Book b1 = new Book();
        b1.id = idGenerator.incrementAndGet();
        b1.title = "Book 1";
        b1.author = "Aiste Eimontaite";
//        p1.image = "/samsung.jpg";
        b1.price = new BigDecimal("20.6");
        b1.quantity = 48L;
        b1.pageNum = 100;
        books.add(b1);

        Book b2 = new Book();
        b2.id = idGenerator.incrementAndGet();
        b2.title = "Book 2";
        b2.author = "Aiste Eimontaite";
//        p2.image = "/samsung.jpg";
        b2.price = new BigDecimal("14.6");
        b2.quantity = 25L;
        b2.pageNum = 200;
        books.add(b2);

        Book b3 = new Book();
        b3.id = idGenerator.incrementAndGet();
        b3.title = "Book 3";
        b3.author = "Aiste Eimontaite";
//        p2.image = "/samsung.jpg";
        b3.price = new BigDecimal("14.6");
        b3.quantity = 25L;
        b3.pageNum = 100;
        books.add(b3);

        Book b4 = new Book();
        b4.id = idGenerator.incrementAndGet();
        b4.title = "Book 4";
        b4.author = "Aiste Eimontaite";
//        p2.image = "/samsung.jpg";
        b4.price = new BigDecimal("14.6");
        b4.pageNum = 200;
        books.add(b4);

        Book b5 = new Book();
        b5.id = idGenerator.incrementAndGet();
        b5.title = "Book 5";
        b5.author = "Aiste Eimontaite";
//        p2.image = "/samsung.jpg";
        b5.price = new BigDecimal("14.6");
        b5.pageNum = 100;
        books.add(b5);

        Book b6 = new Book();
        b6.id = idGenerator.incrementAndGet();
        b6.title = "Book 6";
        b6.author = "Aiste Eimontaite";
//        p2.image = "/samsung.jpg";
        b6.price = new BigDecimal("14.6");
        b6.quantity = 25L;
        b6.pageNum = 200;
        books.add(b6);
    }

    public Book addBook(NewBook b) {
        Book book = new Book();
        book.id = idGenerator.incrementAndGet();
        book.price = b.price;
        book.author = b.author;
//        book.image = b.image;
        book.title = b.title;
        book.quantity = b.quantity;
        books.add(book);
        return book;
    }

    public List<Book> getBooks() {
        return books;
    }
}
