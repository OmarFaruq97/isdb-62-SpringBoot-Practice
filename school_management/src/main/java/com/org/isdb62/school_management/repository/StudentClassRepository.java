package com.org.isdb62.school_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.org.isdb62.school_management.dao.ClassTeacherDTO;
import com.org.isdb62.school_management.dao.ClassTeacherProjection;
//import com.org.isdb62.school_management.dao.ClassTeacherRecord;
import com.org.isdb62.school_management.model.StudentClass;


@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass,Integer> {
    @Query("SELECT sc.name AS className, sc.classTeacher.name AS teacherName, sc.roomNumber AS roomNumber, sc.classTeacher.email AS teacherEmail From StudentClass sc")
    List <ClassTeacherProjection> getAllClassTeacher();

    // @Query("SELECT new com.org.isdb62.school_management.dao.ClassTeacherDTO(sc.name, sc.classTeacher.name) FROM StudentClass sc")
    // List<ClassTeacherDTO> fetchAllClassTeacherDTOs();

    // @Query ("SELECT new com.org.isdb62.school_management.dao.ClassTeacherRecord(sc.name, sc.classTeacherName) FROM StudentClass sc")
    // List<ClassTeacherRecord> fetchAllClassTeacherRecords();

    //Row query
    @Query(
    value = "SELECT sc.name AS className, t.name AS teacherName, sc.room_number AS roomNumber, t.email AS teacherEmail " +
            "FROM student_class sc " +
            "JOIN teacher t ON sc.teacher_id = t.id " +
            "WHERE sc.status = 1",
        nativeQuery = true)
        List<ClassTeacherProjection> findAllActiveClassTeachersNative();
}


