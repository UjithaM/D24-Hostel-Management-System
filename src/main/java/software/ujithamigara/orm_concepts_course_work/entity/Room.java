package software.ujithamigara.orm_concepts_course_work.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
