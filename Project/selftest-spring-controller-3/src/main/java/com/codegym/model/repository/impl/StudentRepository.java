package com.codegym.model.repository.impl;

import com.codegym.model.bean.Student;
import com.codegym.model.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class StudentRepository implements IStudentRepository {

    private static Map<Integer, Student> studentMap;

    static {
        studentMap = new TreeMap<>();
        studentMap.put(123, new Student(123, "Nguyen Van A", "2000-06-15"));
        studentMap.put(654, new Student(654, "Le Van C", "2000-06-14"));
        studentMap.put(234, new Student(234, "Nguyen Van D", "2000-06-12"));
    }

    @Override
    public void save(Student student) {
        int idAutoIncrement = (int) (Math.random() * 1000);
        student.setId(idAutoIncrement);
        studentMap.put(student.getId(), student);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student findById(Integer id) {
        return studentMap.get(id);
    }
}
