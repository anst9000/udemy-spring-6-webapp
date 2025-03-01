package coltla.com.spring6webapp.services;

import coltla.com.spring6webapp.domain.Author;

public interface AuthorService {

  Iterable<Author> findAll();
}
