package com.org.isdb62.school_management.repository;

import com.org.isdb62.school_management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
