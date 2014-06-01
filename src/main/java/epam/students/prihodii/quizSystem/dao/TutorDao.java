package epam.students.prihodii.quizSystem.dao;

import epam.students.prihodii.quizSystem.entity.Tutor;

import java.util.List;

public interface TutorDao {

    Tutor find(Integer id);

    List<Tutor> findAll();

    boolean create(Tutor tutor);
}
