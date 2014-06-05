package epam.students.prihodii.quizSystem.control.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TutorLogin implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("tutor") == null) {
            return "tutor_login";
        } else {
            return "tutor_cabinet";
        }

    }
}
