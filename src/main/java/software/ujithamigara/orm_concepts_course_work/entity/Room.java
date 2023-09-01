package software.ujithamigara.orm_concepts_course_work.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    public Room() {
    }

    public Room(String roomId, String roomTypeId, Double keyMoney, Integer quantity) {
        this.roomId = roomId;
        this.roomTypeId = roomTypeId;
        this.keyMoney = keyMoney;
        this.quantity = quantity;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Double getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(Double keyMoney) {
        this.keyMoney = keyMoney;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
