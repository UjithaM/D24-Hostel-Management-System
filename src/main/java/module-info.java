module software.ujithamigara.orm_concepts_course_work {
    requires javafx.controls;
    requires javafx.fxml;


    opens software.ujithamigara.orm_concepts_course_work to javafx.fxml;
    exports software.ujithamigara.orm_concepts_course_work;
    exports software.ujithamigara.orm_concepts_course_work.Controller;
    opens software.ujithamigara.orm_concepts_course_work.Controller to javafx.fxml;
}