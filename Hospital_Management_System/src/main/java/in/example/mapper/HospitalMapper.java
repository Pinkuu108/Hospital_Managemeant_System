package in.example.mapper;

import org.springframework.stereotype.Component;

import in.example.dto.DoctorDTO;
import in.example.dto.PatientDTO;
import in.example.dto.ReceptionistDTO;

import in.example.entity.Doctor;
import in.example.entity.Patient;
import in.example.entity.Receptionist;

@Component
public class HospitalMapper {

    // ====================== Doctor ============================
    public Doctor toDoctorEntity(DoctorDTO dto) {
        if (dto == null) return null;

        Doctor doctor = new Doctor();
        doctor.setId(dto.getId());
        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setPhone(dto.getPhone());

        return doctor;
    }

    public DoctorDTO toDoctorDTO(Doctor entity) {
        if (entity == null) return null;

        DoctorDTO dto = new DoctorDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSpecialization(entity.getSpecialization());
        dto.setPhone(entity.getPhone());

        return dto;
    }


    // ====================== Receptionist ============================
    public Receptionist toReceptionistEntity(ReceptionistDTO dto) {
        if (dto == null) return null;

        Receptionist receptionist = new Receptionist();
        receptionist.setId(dto.getId());
        receptionist.setName(dto.getName());
        receptionist.setShift(dto.getShift());

        return receptionist;
    }

    public ReceptionistDTO toReceptionistDTO(Receptionist entity) {
        if (entity == null) return null;

        ReceptionistDTO dto = new ReceptionistDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setShift(entity.getShift());

        return dto;
    }


    // ====================== Patient ============================
    public Patient toPatientEntity(PatientDTO dto) {
        if (dto == null) return null;

        Patient patient = new Patient();
        patient.setId(dto.getId());
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setDisease(dto.getDisease());

        // doctorId & receptionistId are handled in service layer,
        // so mapper does not set relationship objects here.

        return patient;
    }

    public PatientDTO toPatientDTO(Patient entity) {
        if (entity == null) return null;

        PatientDTO dto = new PatientDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setDisease(entity.getDisease());

        // Set doctorId if relationship exists
        if (entity.getDoctor() != null) {
            dto.setDoctorId(entity.getDoctor().getId());
        }

        // Set receptionistId if relationship exists
        if (entity.getReceptionist() != null) {
            dto.setReceptionistId(entity.getReceptionist().getId());
        }

        return dto;
    }

}
