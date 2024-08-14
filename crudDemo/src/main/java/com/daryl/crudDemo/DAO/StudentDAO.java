package com.daryl.crudDemo.DAO;
import com.daryl.crudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    public void save(Student student);

    public Student findById(Integer id);

    List<Student> findAll();

    public Student findById2(Integer id);

    public void update(Student student);
}
