package epam.students.prihodii.quizSystem.entity;

public class Quiz {

    private int id;
    private String name;
    private Class quizClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getQuizClass() {
        return quizClass;
    }

    public void setQuizClass(Class quizClass) {
        this.quizClass = quizClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quiz)) return false;

        Quiz quiz = (Quiz) o;

        if (id != quiz.id) return false;
        if (name != quiz.name) return false;
        if (quizClass != null ? !quizClass.equals(quiz.quizClass) : quiz.quizClass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (quizClass != null ? quizClass.hashCode() : 0);
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
