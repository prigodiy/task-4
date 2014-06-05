package epam.students.prihodii.quizSystem.entity;

import java.util.List;

public class Tutor {

    private int id;
    private String login;
    private String password;
    private List<Class> classes;

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tutor)) return false;

        Tutor tutor = (Tutor) o;

        if (id != tutor.id) return false;
        if (!login.equals(tutor.login)) return false;
        if (password != null ? !password.equals(tutor.password) : tutor.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("id = ")
                .append(id)
                .append(" login = ")
                .append(login)
                .toString();
    }
}
