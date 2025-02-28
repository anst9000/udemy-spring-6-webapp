package coltla.com.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import coltla.com.spring6webapp.domain.Author;
import coltla.com.spring6webapp.domain.Book;
import coltla.com.spring6webapp.domain.Publisher;
import coltla.com.spring6webapp.repositories.AuthorRepository;
import coltla.com.spring6webapp.repositories.BookRepository;
import coltla.com.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author();
    eric.setFirstName("Eric");
    eric.setLastName("Evans");

    Book ddd = new Book();
    ddd.setTitle("Domain Driven Design");
    ddd.setIsbn("12345678");

    Author ericSaved = authorRepository.save(eric);
    Book dddSaved = bookRepository.save(ddd);

    Author rod = new Author();
    rod.setFirstName("Rod");
    rod.setLastName("Johnson");

    Book noEjb = new Book();
    noEjb.setTitle("J2EE Development without EJB");
    noEjb.setIsbn("54757585");

    Author rodSaved = authorRepository.save(rod);
    Book noEjbSaved = bookRepository.save(noEjb);

    ericSaved.getBooks().add(dddSaved);
    rodSaved.getBooks().add(noEjbSaved);
    dddSaved.getAuthors().add(ericSaved);
    noEjbSaved.getAuthors().add(rodSaved);

    Publisher publisher = new Publisher();
    publisher.setName("Robert Fleck");
    publisher.setAddress("123 Main");
    Publisher savedPublisher = publisherRepository.save(publisher);

    dddSaved.setPublisher(savedPublisher);
    noEjbSaved.setPublisher(savedPublisher);

    authorRepository.save(ericSaved);
    authorRepository.save(rodSaved);
    bookRepository.save(dddSaved);
    bookRepository.save(noEjbSaved);

    System.out.println("In Bootstrap");
    System.out.println("Author count: " + authorRepository.count());
    System.out.println("Book count: " + bookRepository.count());
    System.out.println("Publisher count: " + publisherRepository.count());
  }

}
