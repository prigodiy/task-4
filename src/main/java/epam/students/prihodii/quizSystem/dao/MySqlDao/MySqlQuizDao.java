package epam.students.prihodii.quizSystem.dao.MySqlDao;

import epam.students.prihodii.quizSystem.dao.DaoFactory;
import epam.students.prihodii.quizSystem.dao.interfaces.QuizDao;
import epam.students.prihodii.quizSystem.entity.*;
import epam.students.prihodii.quizSystem.entity.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static epam.students.prihodii.quizSystem.dao.DaoJdbcUtil.close;

public class MySqlQuizDao implements QuizDao {

    private DaoFactory daoFactory;

    private static final String FIND_QUIZZES_BY_CLASS_ID_SQL = "SELECT quiz_id, name FROM quizzes WHERE class_id=(?)";

    public MySqlQuizDao(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<Quiz> findQuizzesByClassId(int classId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Quiz> quizzes = new ArrayList<Quiz>();
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(FIND_QUIZZES_BY_CLASS_ID_SQL);
            preparedStatement.setInt(1, classId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                quizzes.add(map(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return quizzes;
    }

    private Quiz map(ResultSet resultSet) throws SQLException {
        Quiz quiz = new Quiz();
        quiz.setId(resultSet.getInt(1));
        quiz.setName(resultSet.getString(2));
        return quiz;
    }
}
