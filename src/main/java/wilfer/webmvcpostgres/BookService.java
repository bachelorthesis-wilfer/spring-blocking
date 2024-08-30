package wilfer.webmvcpostgres;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> updateBook(Book book, Long bookId) {
        return bookRepository.findById(bookId)
                .map(persistedBook -> {
                    persistedBook.setAuthor(book.getAuthor());
                    persistedBook.setTitle(book.getTitle());
                    persistedBook.setPrice(book.getPrice());
                    persistedBook.setIsbn(book.getIsbn());
                    return Optional.of(bookRepository.save(persistedBook));
                })
                .orElseGet(Optional::empty);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}

