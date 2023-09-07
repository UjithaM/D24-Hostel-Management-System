package software.ujithamigara.orm_concepts_course_work.bo;

import software.ujithamigara.orm_concepts_course_work.bo.custrom.impl.ReservationBOImpl;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.impl.RoomBOImpl;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.impl.StudentBOImpl;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }
    public enum BOType {
        ReservationBO,
        RoomBO,
        StudentBO,
        UserBO
    }

    public  SuperBo getBo(BOType type){
        switch (type) {
            case ReservationBO:
                return new ReservationBOImpl();
            case RoomBO:
                return new RoomBOImpl();
            case StudentBO:
                return new StudentBOImpl();
            case UserBO:
                return new UserBOImpl();
            default:
                return null;
        }
    }
}
