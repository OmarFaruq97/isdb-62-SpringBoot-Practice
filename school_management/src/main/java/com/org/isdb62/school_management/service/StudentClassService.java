package com.org.isdb62.school_management.service;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.isdb62.school_management.dto.StudentClassDTO;
import com.org.isdb62.school_management.model.StudentClass;
import com.org.isdb62.school_management.model.Teacher;
import com.org.isdb62.school_management.repository.StudentClassRepository;

@Service
public class StudentClassService {

    private final StudentClassRepository studentClassRepository;
    private final TeacherService teacherService;

    public StudentClassService(StudentClassRepository studentClassRepository,
                        TeacherService teacherService){
        this.studentClassRepository = studentClassRepository;
        this.teacherService = teacherService;
    }    

    public StudentClass saveStudentClass(StudentClassDTO classDTO) {
        Integer teacherId = classDTO.getClassTeacherId();
        Teacher teacher =  teacherService.getTeacher(teacherId);      
        if (teacher == null){
            throw new IllegalArgumentException("Teacher not found");
        }

    StudentClass studentClass = new StudentClass();
    studentClass.setName(classDTO.getName());
    studentClass.setRoomNumber(classDTO.getRoomNumber());
    studentClass.setClassTeacher(teacher);

    return studentClassRepository.save(studentClass);
    }
    

    public StudentClass getStudentClass(Integer id) {
        return studentClassRepository.findById(id).orElse(null);
    }

    public  void deleteStudentClass(Integer id) {
        
    }

    public StudentClass UpdateStudentClass(Integer id, StudentClassDTO classDTO) {
        Optional <StudentClass> classById = studentClassRepository.findById(id);

        if(classById.isPresent()){
            StudentClass aClass = new StudentClass();
            if(classDTO.getName() != null){
                aClass.setName(classDTO.getName());
            }
            if (classDTO.getRoomNumber() !=null) {
                aClass.setRoomNumber(classDTO.getRoomNumber());                
            }
            if (classDTO.getClassTeacherId() != null) {
                Integer teacherId = classDTO.getClassTeacherId();
                Teacher teacher = teacherService.getTeacher(teacherId);
                if (teacher == null) {
                    throw new IllegalArgumentException("Teacher not found");                  
                }
                aClass.setClassTeacher(teacher);                
            }
            return studentClassRepository.save(aClass);            
        }
    }
}

