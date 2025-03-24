package com.org.isdb62.school_management.repository;

<<<<<<< HEAD

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.isdb62.school_management.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
=======
import com.org.isdb62.school_management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
>>>>>>> 3d4a7c14f5d57766d3bb5f7c97d8059c278ad770
}
