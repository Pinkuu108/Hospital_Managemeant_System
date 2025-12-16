package in.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import in.example.dto.PatientDTO;
import in.example.entity.Doctor;
import in.example.entity.Patient;
import in.example.entity.Receptionist;
import in.example.mapper.HospitalMapper;
import in.example.repository.DoctorRepository;
import in.example.repository.PatientRepository;
import in.example.repository.ReceptionistRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private ReceptionistRepository receptionistRepository;

	@Autowired
	private HospitalMapper mapper;

	@Override
	public PatientDTO savePatient(PatientDTO dto) {

		Patient patient = mapper.toPatientEntity(dto);

		// Set doctor
		Doctor doctor = doctorRepository.findById(dto.getDoctorId()).orElse(null);
		patient.setDoctor(doctor);

		// Set receptionist
		Receptionist rec = receptionistRepository.findById(dto.getReceptionistId()).orElse(null);
		patient.setReceptionist(rec);

		Patient saved = patientRepository.save(patient);
		return mapper.toPatientDTO(saved);
	}

	@Override
	public PatientDTO updatePatient(PatientDTO dto) {

		Patient patient = mapper.toPatientEntity(dto);

		Doctor doctor = doctorRepository.findById(dto.getDoctorId()).orElse(null);
		patient.setDoctor(doctor);

		Receptionist rec = receptionistRepository.findById(dto.getReceptionistId()).orElse(null);
		patient.setReceptionist(rec);

		Patient updated = patientRepository.save(patient);
		return mapper.toPatientDTO(updated);
	}

	@Override
	public void deletePatient(Integer id) {
		patientRepository.deleteById(id);
	}

	@Override
	public PatientDTO getPatientById(Integer id) {
		return patientRepository.findById(id).map(mapper::toPatientDTO).orElse(null);
	}

	@Override
	public List<PatientDTO> getAllPatients() {
		return patientRepository.findAll().stream().map(mapper::toPatientDTO).collect(Collectors.toList());
	}

	@Override
	public List<PatientDTO> getPatientsByDoctor(Integer doctorId) {

		Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
		if (doctor == null)
			return List.of();

		return patientRepository.findByDoctor(doctor).stream().map(mapper::toPatientDTO).collect(Collectors.toList());
	}

	@Override
	public List<PatientDTO> getPatientsByReceptionist(Integer receptionistId) {

		Receptionist rec = receptionistRepository.findById(receptionistId).orElse(null);
		if (rec == null)
			return List.of();

		return patientRepository.findByReceptionist(rec).stream().map(mapper::toPatientDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Long countPatientsByDoctor(Integer doctorId) {
		return patientRepository.countByDoctorId(doctorId);
	}

	@Override
	public PatientDTO assignDoctor(Integer patientId, Integer doctorId) {

		Patient patient = patientRepository.findById(patientId).orElse(null);
		Doctor doctor = doctorRepository.findById(doctorId).orElse(null);

		if (patient == null || doctor == null)
			return null;

		patient.setDoctor(doctor);
		Patient updated = patientRepository.save(patient);

		return mapper.toPatientDTO(updated);
	}

	@Override
	public PatientDTO assignReceptionist(Integer patientId, Integer receptionistId) {

		Patient patient = patientRepository.findById(patientId).orElse(null);
		Receptionist rec = receptionistRepository.findById(receptionistId).orElse(null);

		if (patient == null || rec == null)
			return null;

		patient.setReceptionist(rec);
		Patient updated = patientRepository.save(patient);

		return mapper.toPatientDTO(updated);
	}
	
	@Override
	public List<PatientDTO> getAllPatientsSorted(String field) {
	    return patientRepository.findAll(Sort.by(field))
	            .stream()
	            .map(mapper::toPatientDTO)
	            .collect(Collectors.toList());
	}


}
