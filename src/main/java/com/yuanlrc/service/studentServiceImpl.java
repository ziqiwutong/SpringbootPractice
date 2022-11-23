package com.yuanlrc.service;

import com.yuanlrc.dao.studentDao;
import com.yuanlrc.entity.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentServiceImpl implements  studentService{

    @Autowired
    private com.yuanlrc.dao.studentDao studentDao;

    @Override
    public student selectById(Integer id) {
        return studentDao.selectById(id);
    }

    @Override
    public List<student> selectStudents() {
        return null;
    }

    @Override
    public int insertStudent(student student) {
        return 0;
    }
}
