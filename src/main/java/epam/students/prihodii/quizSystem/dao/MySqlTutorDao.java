package epam.students.prihodii.quizSystem.dao;

import epam.students.prihodii.quizSystem.entity.Tutor;
import static epam.students.prihodii.quizSystem.dao.DaoJdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySqlTutorDao implements TutorDao {

    private DaoFactory daoFactory;

    private static final String INSERT_TUTOR_SQL = "INSERT INTO tutors (login, password) VALUES (?, ?)";

    public MySqlTutorDao(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Tutor find(Integer id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Tutor> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean create(Tutor tutor) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_TUTOR_SQL);
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

    public static void main(String[] args) {
        DaoFactory df = DaoFactory.getDaoFactory(DaoFactory.ConnTypes.DriverManagerMySql);
        TutorDao t = df.getTutorDao();
        System.out.println(t.create(new Tutor("hello", "world")));
    }
}
