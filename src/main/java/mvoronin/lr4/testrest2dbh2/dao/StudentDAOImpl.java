package mvoronin.lr4.testrest2dbh2.dao;

import lombok.extern.slf4j.Slf4j;
import mvoronin.lr4.testrest2dbh2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        var query = entityManager.createQuery("from Student");
        var allStudents = query.getResultList();
        log.info("getAllStudents {}", allStudents);
        return allStudents;
    }

    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Student getStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteStudent(int id) {
        var query = entityManager.createQuery("delete from Student where id=:studentId");
        query.setParameter("studentId", id);
        query.executeUpdate();
    }
}
