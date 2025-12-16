package in.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.example.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	@Query("SELECT d FROM Doctor d WHERE d.specialization = :spec")
	List<Doctor> findBySpecialization(@Param("spec") String specialization);

}