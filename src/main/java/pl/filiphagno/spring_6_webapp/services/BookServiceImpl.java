package pl.filiphagno.spring_6_webapp.services;

import pl.filiphagno.spring_6_webapp.domain.Book;
import pl.filiphagno.spring_6_webapp.repositories.BookRepository;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
