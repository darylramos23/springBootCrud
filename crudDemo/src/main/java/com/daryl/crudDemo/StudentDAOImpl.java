package com.daryl.crudDemo;

import com.daryl.crudDemo.DAO.StudentDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import com.daryl.crudDemo.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student student){
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id){ // using find
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll(){

        TypedQuery<Student> theQuery = entityManager.createQuery("From Student",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public Student findById2(Integer id){ //using query
        TypedQuery<Student> query =  entityManager.createQuery("From Student where id=:id",Student.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void update(Student student){
        entityManager.merge(student);
    }
}
