package in.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Doctor {

    @Id
    private Integer id;

    private String name;
    private String specialization;
    private String phone;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;
}
