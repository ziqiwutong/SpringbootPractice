package com.yuanlrc.dao;

import com.yuanlrc.entity.student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface studentDao {
    student selectById(Integer id);

    List<student> selectStudents();

    int insertStudent(student student);
}
