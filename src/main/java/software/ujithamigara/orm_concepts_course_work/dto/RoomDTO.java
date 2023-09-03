package software.ujithamigara.orm_concepts_course_work.dto;

import jakarta.persistence.Column;

public class RoomDTO {
    private String roomId;

    private String roomTypeId;

    private Double keyMoney;

    private Integer quantity;

    public RoomDTO(String roomId, String roomTypeId, Double keyMoney, Integer quantity) {
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
