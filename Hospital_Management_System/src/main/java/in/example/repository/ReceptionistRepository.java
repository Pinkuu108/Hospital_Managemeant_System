package in.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.example.entity.Receptionist;

public interface ReceptionistRepository extends JpaRepository<Receptionist, Integer> {

}
