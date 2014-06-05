package epam.students.prihodii.quizSystem.dao.interfaces;

import epam.students.prihodii.quizSystem.entity.Quiz;

import java.util.List;

public interface QuizDao {

    public List<Quiz> findQuizzesByClassId(int classId);
}
