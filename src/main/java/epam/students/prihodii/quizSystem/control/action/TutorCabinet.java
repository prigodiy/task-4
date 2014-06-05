package epam.students.prihodii.quizSystem.control.action;

import epam.students.prihodii.quizSystem.dao.DaoFactory;
import epam.students.prihodii.quizSystem.entity.Tutor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TutorCabinet implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("tutor") == null) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            DaoFactory daoFactory = DataSourceDaoFactory.getDAOFactory();
            Tutor tutor = daoFactory.getTutorDao().findByLogin(login, password);
            if (tutor != null) {
                request.getSession().setAttribute("tutor", tutor);
                return "tutor_cabinet";
            } else {
                return "error_page";
            }
        } else {
            return "tutor_cabinet";
        }
    }
}
