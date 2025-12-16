package in.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorDTO {

    private Integer id;
    private String name;
    private String specialization;
    private String phone;
}
