package lt.egzaminas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lt.egzaminas.model.Book;
import lt.egzaminas.model.NewBook;
import lt.egzaminas.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository repository;

	@GetMapping("/api/books")
	public List<Book> getBooks() {
		return repository.getBooks();
	}

	@GetMapping("/api/books/{bookId}")
	public Book getBook(@PathVariable Long productId) {
		return repository.getBooks().stream().filter(p -> p.id.equals(productId)).findFirst()
				.orElseThrow(() -> new RuntimeException("Book not found"));
	}

	@PostMapping("/api/books")
	public Book createBook(@RequestBody NewBook b) {
		return repository.addBook(b);
	}

	@PutMapping("/api/books/{bookId}")
	public Book updateBook(@PathVariable Long bookId, @RequestBody NewBook b) {
		Book existingBook = getBook(bookId);
		existingBook.title = b.title;
		existingBook.author = b.author;
		existingBook.quantity = b.quantity;
		existingBook.price = b.price;
		existingBook.pageNum = b.pageNum;
		return existingBook;
	}
}
