package in.example.service;

import java.util.List;
import in.example.dto.DoctorDTO;

public interface DoctorService {

	DoctorDTO saveDoctor(DoctorDTO dto);

	DoctorDTO updateDoctor(DoctorDTO dto);

	void deleteDoctor(Integer id);

	DoctorDTO getDoctorById(Integer id);

	List<DoctorDTO> getAllDoctors();
	
	List<DoctorDTO> getDoctorsBySpecialization(String specialization);

}
