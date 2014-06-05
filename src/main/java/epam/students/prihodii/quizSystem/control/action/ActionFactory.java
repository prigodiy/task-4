package epam.students.prihodii.quizSystem.control.action;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory {

    private static final Map<String, Action> actions;

    static {
        actions = new HashMap<String, Action>();
        actions.put("/tutor_login", new TutorLogin());
        actions.put("/tutor_cabinet", new TutorCabinet());
        actions.put("/tutor_class", new TutorClass());
        actions.put("/tutor_add_class", new TutorAddClass());
        actions.put("/tutor_logout", new TutorLogout());
    }

    public static Action getAction(HttpServletRequest request) {
        return actions.get(request.getPathInfo());
    }
}
