package in.example.service;

import java.util.List;

import in.example.dto.PatientDTO;

public interface PatientService {

	PatientDTO savePatient(PatientDTO dto);

	PatientDTO updatePatient(PatientDTO dto);

	void deletePatient(Integer id);

	PatientDTO getPatientById(Integer id);

	List<PatientDTO> getAllPatients();

	List<PatientDTO> getPatientsByDoctor(Integer doctorId);

	List<PatientDTO> getPatientsByReceptionist(Integer receptionistId);

	Long countPatientsByDoctor(Integer doctorId);

	PatientDTO assignDoctor(Integer patientId, Integer doctorId);

	PatientDTO assignReceptionist(Integer patientId, Integer receptionistId);

	List<PatientDTO> getAllPatientsSorted(String field);

}
