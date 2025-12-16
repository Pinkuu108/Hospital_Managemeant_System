package in.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReceptionistDTO {

    private Integer id;
    private String name;
    private String shift;
}
