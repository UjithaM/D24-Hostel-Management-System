package software.ujithamigara.orm_concepts_course_work.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String roomId;

    private String roomTypeId;

    private Double keyMoney;

    private Integer quantity;
}
