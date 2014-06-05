package epam.students.prihodii.quizSystem.dao.MySqlDao;

import epam.students.prihodii.quizSystem.dao.DaoFactory;
import epam.students.prihodii.quizSystem.dao.interfaces.ClassDao;
import epam.students.prihodii.quizSystem.entity.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static epam.students.prihodii.quizSystem.dao.DaoJdbcUtil.close;

public class MySqlClassDao implements ClassDao {

    private DaoFactory daoFactory;

    private static final String FIND_CLASS_BY_TUTOR_ID_SQL =
            "SELECT classes.class_id, classes.name " +
            "FROM tutors " +
            "INNER JOIN classes " +
            "ON tutors.tutor_id=classes.tutor_id " +
            "WHERE classes.tutor_id=(?)";

    private static final String CREATE_ClASS_SQL = "INSERT INTO classes (name, tutor_id) VALUES (?, ?)";

    public MySqlClassDao(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public boolean create(Class aClass) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_ClASS_SQL);
            preparedStatement.setString(1, aClass.getName());
            preparedStatement.setInt(2, aClass.getTutorId());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }

    public List<Class> findClassesByTutorId(int tutorId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Class> classes = new ArrayList<Class>();
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(FIND_CLASS_BY_TUTOR_ID_SQL);
            preparedStatement.setInt(1, tutorId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                classes.add(map(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return classes;
    }

    private Class map(ResultSet resultSet) throws SQLException {
        Class aClass = new Class();
        aClass.setId(resultSet.getInt(1));
        aClass.setName(resultSet.getString(2));
        return aClass;
    }
}
