package coltla.com.spring6webapp.services;

import coltla.com.spring6webapp.domain.Book;

public interface BookService {

  Iterable<Book> findAll();

}
