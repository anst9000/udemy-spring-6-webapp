package com.coltla.spring6webapp.services;

import com.coltla.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
