package pl.filiphagno.spring_6_webapp.services;

import pl.filiphagno.spring_6_webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
