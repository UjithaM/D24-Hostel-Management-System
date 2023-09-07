package software.ujithamigara.orm_concepts_course_work.dao;

import software.ujithamigara.orm_concepts_course_work.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DaoTypes {
        ReservationDao,
        RoomDao,
        StudentsDao,
        UserDao,
        QueryDao
    }

    public SuperDAO getDao(DaoTypes type) {
        switch (type) {
            case UserDao:
                return new UserDAOImpl();
            case RoomDao:
                return new RoomDAOImpl();
            case StudentsDao:
                return new StudentDAOImpl();
            case ReservationDao:
                return new ReservationDAOImpl();
            case QueryDao:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}
