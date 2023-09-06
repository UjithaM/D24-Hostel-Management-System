package software.ujithamigara.orm_concepts_course_work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "room_id")
    private String roomId;

    @Column(name = "room_type")
    private String roomTypeId;

    @Column(name = "key_money")
    private Double keyMoney;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "room", targetEntity = Reservation.class)
    List<Reservation> reservationList = new ArrayList<>();
}
