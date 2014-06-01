package epam.students.prihodii.quizSystem.entity;

import java.util.ArrayList;
import java.util.List;

public class Class {

    private int id;
    private String name;
    private List<Quiz> quizzes = new ArrayList<Quiz>();
    private List<Student> students = new ArrayList<Student>();

    public Class(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Class)) return false;

        Class aClass = (Class) o;

        if (id != aClass.id) return false;
        if (!name.equals(aClass.name)) return false;
        if (!quizzes.equals(aClass.quizzes)) return false;
        if (!students.equals(aClass.students)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + quizzes.hashCode();
        result = 31 * result + students.hashCode();
        return result;
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
