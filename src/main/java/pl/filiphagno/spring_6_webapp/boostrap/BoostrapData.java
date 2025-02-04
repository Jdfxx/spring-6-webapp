package pl.filiphagno.spring_6_webapp.boostrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.filiphagno.spring_6_webapp.domain.Author;
import pl.filiphagno.spring_6_webapp.domain.Book;
import pl.filiphagno.spring_6_webapp.domain.Publisher;
import pl.filiphagno.spring_6_webapp.repositories.AuthorRepository;
import pl.filiphagno.spring_6_webapp.repositories.BookRepository;
import pl.filiphagno.spring_6_webapp.repositories.PublisherRepository;

@Component
public class BoostrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final  PublisherRepository publisherRepository;

    public BoostrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher pub1 = new Publisher();
        pub1.setPublisherName("Some publisher");
        pub1.setAddress("Some street");
        pub1.setCity("Some city");
        pub1.setZip("Some zip");
        pub1.setState("Some state");

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);
        Publisher pub1Saved = publisherRepository.save(pub1);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        pub1Saved.getBooks().add(dddSaved);
        pub1Saved.getBooks().add(noEJBSaved);
        dddSaved.setPublisher(pub1Saved);
        noEJBSaved.setPublisher(pub1Saved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        publisherRepository.save(pub1Saved);
        bookRepository.save(noEJBSaved);
        bookRepository.save(dddSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
