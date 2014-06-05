package epam.students.prihodii.quizSystem.dao.MySqlDao;

import epam.students.prihodii.quizSystem.dao.DaoFactory;
import epam.students.prihodii.quizSystem.dao.interfaces.TutorDao;
import epam.students.prihodii.quizSystem.entity.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static epam.students.prihodii.quizSystem.dao.DaoJdbcUtil.close;

public class MySqlTutorDao implements TutorDao {

    private DaoFactory daoFactory;

    private static final String FIND_TUTOR_BY_LOGIN_SQL = "SELECT tutor_id, login, password FROM tutors WHERE login = (?) AND password = (?)";
    private static final String FIND_ALL_TUTORS_SQL = "SELECT * FROM tutors";
    private static final String CREATE_TUTOR_SQL = "INSERT INTO tutors (login, password) VALUES (?, ?)";

    public MySqlTutorDao(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Tutor findByLogin(String login, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Tutor tutor = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(FIND_TUTOR_BY_LOGIN_SQL);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tutor = map(resultSet);
                return tutor;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return tutor;
    }

    public List<Tutor> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Tutor> tutors = new ArrayList<Tutor>();
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL_TUTORS_SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tutors.add(map(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return tutors;
    }

    public boolean create(Tutor tutor) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_TUTOR_SQL);
            preparedStatement.setString(1, tutor.getLogin());
            preparedStatement.setString(2, tutor.getPassword());
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

    private Tutor map(ResultSet resultSet) throws SQLException {
        Tutor tutor = new Tutor();
        tutor.setId(resultSet.getInt(1));
        tutor.setLogin(resultSet.getString(2));
        tutor.setPassword(resultSet.getString(3));
        tutor.setClasses(DaoFactory.getDaoFactory(DaoFactory.ConnTypes.ConnPoolMySql).getClassDao().findClassesByTutorId(resultSet.getInt(1)));
        return tutor;
    }
}
