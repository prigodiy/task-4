package epam.students.prihodii.quizSystem.control.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TutorLogout implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().removeAttribute("tutor");
        return "tutor_login";
    }
}
