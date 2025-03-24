package com.org.isdb62.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import com.org.isdb62.school_management.model.Student;

=======
import org.springframework.stereotype.Repository;
import com.org.isdb62.school_management.model.Student;

@Repository
>>>>>>> 3d4a7c14f5d57766d3bb5f7c97d8059c278ad770
public interface StudentClassRepository extends JpaRepository<Student,Integer> {
}
