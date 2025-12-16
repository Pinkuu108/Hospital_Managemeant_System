package in.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Receptionist {

    @Id
    private Integer id;

    private String name;
    private String shift;

    @OneToMany(mappedBy = "receptionist")
    private List<Patient> patients;
}
