package epam.students.prihodii.quizSystem.control;

import epam.students.prihodii.quizSystem.control.action.Action;
import epam.students.prihodii.quizSystem.control.action.ActionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControlServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String view = null;

        Action action = ActionFactory.getAction(request);
        try {
            view = action.execute(request, response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        dispatch(request, response, view);
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String view)
            throws ServletException, IOException {
        String prefix = "/view/";
        String suffix = ".jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + view + suffix);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
