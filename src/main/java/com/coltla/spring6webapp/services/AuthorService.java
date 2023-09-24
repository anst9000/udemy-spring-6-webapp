package com.coltla.spring6webapp.services;

import com.coltla.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
