package epam.students.prihodii.quizSystem.control.action;

import epam.students.prihodii.quizSystem.dao.DaoFactory;
import epam.students.prihodii.quizSystem.entity.Class;
import epam.students.prihodii.quizSystem.entity.Tutor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TutorAddClass implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String newClassName = request.getParameter("newClassName");
        if (newClassName != null && newClassName.length() > 0) {
            DaoFactory daoFactory = DataSourceDaoFactory.getDAOFactory();
            Class aClass = new Class();
            Tutor tutor = (Tutor) request.getSession().getAttribute("tutor");
            aClass.setName(newClassName);
            aClass.setTutorId(tutor.getId());
            daoFactory.getClassDao().create(aClass);
        }
        return "tutor_cabinet";
    }
}
