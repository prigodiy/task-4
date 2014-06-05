package epam.students.prihodii.quizSystem.dao;

import epam.students.prihodii.quizSystem.dao.MySqlDao.MySqlClassDao;
import epam.students.prihodii.quizSystem.dao.MySqlDao.MySqlQuizDao;
import epam.students.prihodii.quizSystem.dao.MySqlDao.MySqlTutorDao;
import epam.students.prihodii.quizSystem.dao.interfaces.ClassDao;
import epam.students.prihodii.quizSystem.dao.interfaces.QuizDao;
import epam.students.prihodii.quizSystem.dao.interfaces.TutorDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnPoolMySqlDaoFactory extends DaoFactory {

    private static DataSource pool;

    public ConnPoolMySqlDaoFactory() {
        if (pool == null) {
            try {
                Context ctx = (Context) new InitialContext().lookup("java:/comp/env");
                pool = (DataSource) ctx.lookup("jdbc/quiz_system_db");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    @Override
    public TutorDao getTutorDao() {
        return new MySqlTutorDao(this);
    }

    @Override
    public ClassDao getClassDao() {
        return new MySqlClassDao(this);
    }

    @Override
    public QuizDao getQuizDao() {
        return new MySqlQuizDao(this);
    }
}
