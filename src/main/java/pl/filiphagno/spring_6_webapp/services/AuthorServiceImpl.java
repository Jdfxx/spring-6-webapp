package pl.filiphagno.spring_6_webapp.services;

import org.springframework.stereotype.Service;
import pl.filiphagno.spring_6_webapp.domain.Author;
import pl.filiphagno.spring_6_webapp.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findA() {
        return authorRepository.findAll();
    }
}
