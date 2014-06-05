package epam.students.prihodii.quizSystem.control.action;

import epam.students.prihodii.quizSystem.dao.DaoFactory;
import epam.students.prihodii.quizSystem.entity.Quiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TutorClass implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int classId = Integer.valueOf(request.getParameter("classId"));
        //TODO
        DaoFactory daoFactory =DataSourceDaoFactory.getDAOFactory();
        List<Quiz> quizzes = daoFactory.getQuizDao().findQuizzesByClassId(classId);
        request.getSession().setAttribute("quizzes", quizzes);
        return "tutor_class";
    }
}
