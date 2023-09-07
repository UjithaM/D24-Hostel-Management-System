package software.ujithamigara.orm_concepts_course_work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
}
