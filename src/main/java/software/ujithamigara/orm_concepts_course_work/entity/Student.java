package software.ujithamigara.orm_concepts_course_work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@Entity
public class Student {

    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "gender")
    private String gender;

    @OneToMany(targetEntity = Reservation.class, mappedBy = "student")
    private List<Reservation> reservationList = new ArrayList<>();
}
