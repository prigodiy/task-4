package epam.students.prihodii.quizSystem.dao.interfaces;

import epam.students.prihodii.quizSystem.entity.Tutor;

import java.util.List;

public interface TutorDao {

    public Tutor findByLogin(String login, String password);

    public List<Tutor> findAll();

    public boolean create(Tutor tutor);
}
