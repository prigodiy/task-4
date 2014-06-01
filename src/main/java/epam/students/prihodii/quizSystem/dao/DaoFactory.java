package epam.students.prihodii.quizSystem.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DaoFactory {

    public enum ConnTypes {
        DriverManagerMySql,
        ConnPoolMySql;
    }

    public static DaoFactory getDaoFactory(ConnTypes connType) {
        switch (connType) {
            case DriverManagerMySql:
                return new DriverManagerMySqlDaoFactory();
            case ConnPoolMySql:
                return new ConnPoolMySqlDaoFactory();
            default:
                return null;
        }
    }

    public abstract Connection getConnection() throws SQLException;

    public abstract TutorDao getTutorDao();
}
