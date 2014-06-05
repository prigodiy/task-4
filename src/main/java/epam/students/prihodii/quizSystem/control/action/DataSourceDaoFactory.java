package epam.students.prihodii.quizSystem.control.action;

import epam.students.prihodii.quizSystem.dao.DaoFactory;

public class DataSourceDaoFactory {

    public static DaoFactory getDAOFactory() {
        return DaoFactory.getDaoFactory(DaoFactory.ConnTypes.ConnPoolMySql);
    }
}