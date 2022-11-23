package com.yuanlrc.service;

import com.yuanlrc.entity.student;

import java.util.List;

public interface studentService {
    student selectById(Integer id);

    List<student> selectStudents();

    int insertStudent(student student);
}
