package epam.students.prihodii.quizSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerMySqlDaoFactory extends DaoFactory {

    @Override
    public Connection getConnection() throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/quiz_system_db";
        String user = "root";
        String pass = "root";
        return DriverManager.getConnection(url, user, pass);
    }

    @Override
    public TutorDao getTutorDao() {
        return new MySqlTutorDao(this);
    }
}
