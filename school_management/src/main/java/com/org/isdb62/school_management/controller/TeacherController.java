package com.org.isdb62.school_management.controller;

import com.org.isdb62.school_management.model.Teacher;
import com.org.isdb62.school_management.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @PostMapping
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Integer id){
        return teacherService.getTeacher(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher (@PathVariable Integer id){
        teacherService.deleteTeacher(id);
    }

    @GetMapping
    public List<Teacher> getAllTeacher(){
        return teacherService.getAllTeacher();
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher (@PathVariable Integer id,@RequestBody Teacher teacher){
        return teacherService.updateTeacher(id, teacher);
    }

}



