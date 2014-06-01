package epam.students.prihodii.quizSystem.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private List<Class> classes = new ArrayList<Class>();

    public Student(int id, String login, String password, String name, String surname, List<Class> classes) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.classes = classes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (!classes.equals(student.classes)) return false;
        if (!login.equals(student.login)) return false;
        if (!name.equals(student.name)) return false;
        if (!password.equals(student.password)) return false;
        if (!surname.equals(student.surname)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + classes.hashCode();
        return result;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("id = ")
                .append(id)
                .append(" name = ")
                .append(name)
                .toString();
    }
}
