package in.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.example.dto.DoctorDTO;
import in.example.entity.Doctor;
import in.example.mapper.HospitalMapper;
import in.example.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private HospitalMapper mapper;

    @Override
    public DoctorDTO saveDoctor(DoctorDTO dto) {
        Doctor doctor = mapper.toDoctorEntity(dto);
        Doctor saved = doctorRepository.save(doctor);
        return mapper.toDoctorDTO(saved);
    }

    @Override
    public DoctorDTO updateDoctor(DoctorDTO dto) {
        Doctor doctor = mapper.toDoctorEntity(dto);
        Doctor updated = doctorRepository.save(doctor);
        return mapper.toDoctorDTO(updated);
    }

    @Override
    public void deleteDoctor(Integer id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorDTO getDoctorById(Integer id) {
        return doctorRepository.findById(id)
                .map(mapper::toDoctorDTO)
                .orElse(null);
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(mapper::toDoctorDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<DoctorDTO> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization)
                .stream()
                .map(mapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

}
