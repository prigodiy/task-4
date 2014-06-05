package epam.students.prihodii.quizSystem.dao.interfaces;

import epam.students.prihodii.quizSystem.entity.Class;

import java.util.List;

public interface ClassDao {

    public List<Class> findClassesByTutorId(int tutorId);

    public boolean create(Class aClass);
}
