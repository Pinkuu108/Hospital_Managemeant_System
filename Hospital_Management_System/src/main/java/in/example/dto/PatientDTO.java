package in.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientDTO {

    private Integer id;
    private String name;
    private int age;
    private String disease;

    private Integer doctorId;        
    private Integer receptionistId;  
}
