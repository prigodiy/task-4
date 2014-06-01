package epam.students.prihodii.quizSystem.entity;

import java.util.Arrays;

public class Question {

    private int id;
    private String desc;
    private Quiz quiz;
    private String[] variants = new String[8];
    private boolean[] rightMask = new boolean[8];

    public Question(int id, String desc, Quiz quiz, String[] variants, boolean[] rightMask) {
        this.id = id;
        this.desc = desc;
        this.quiz = quiz;
        this.variants = variants;
        this.rightMask = rightMask;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String[] getVariants() {
        return variants;
    }

    public void setVariants(String[] variants) {
        this.variants = variants;
    }

    public boolean[] getRightMask() {
        return rightMask;
    }

    public void setRightMask(boolean[] rightMask) {
        this.rightMask = rightMask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question = (Question) o;

        if (id != question.id) return false;
        if (!desc.equals(question.desc)) return false;
        if (!quiz.equals(question.quiz)) return false;
        if (!Arrays.equals(rightMask, question.rightMask)) return false;
        if (!Arrays.equals(variants, question.variants)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + desc.hashCode();
        result = 31 * result + quiz.hashCode();
        result = 31 * result + Arrays.hashCode(variants);
        result = 31 * result + Arrays.hashCode(rightMask);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("id = ")
                .append(id)
                .append(" desc = ")
                .append(desc)
                .toString();
    }
}
