package in.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.example.entity.Doctor;
import in.example.entity.Patient;
import in.example.entity.Receptionist;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	List<Patient> findByDoctor(Doctor doctor);

	List<Patient> findByReceptionist(Receptionist receptionist);

	@Query("SELECT COUNT(p) FROM Patient p WHERE p.doctor.id = :doctorId")
	Long countByDoctorId(@Param("doctorId") Integer doctorId);

}
