package in.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.example.dto.PatientDTO;
import in.example.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // ========== CREATE ==========
    @PostMapping("/save")
    public PatientDTO savePatient(@RequestBody PatientDTO dto) {
        return patientService.savePatient(dto);
    }

    // ========== UPDATE ==========
    @PutMapping("/update")
    public PatientDTO updatePatient(@RequestBody PatientDTO dto) {
        return patientService.updatePatient(dto);
    }

    // ========== DELETE ==========
    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable Integer id) {
        patientService.deletePatient(id);
        return "Patient deleted successfully with ID: " + id;
    }

    // ========== GET BY ID ==========
    @GetMapping("/get/{id}")
    public PatientDTO getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id);
    }

    // ========== GET ALL ==========
    @GetMapping("/all")
    public List<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }
    
 // Get patients by doctor
    @GetMapping("/doctor/{doctorId}")
    public List<PatientDTO> getByDoctor(@PathVariable Integer doctorId) {
        return patientService.getPatientsByDoctor(doctorId);
    }

    // Get patients by receptionist
    @GetMapping("/receptionist/{recId}")
    public List<PatientDTO> getByReceptionist(@PathVariable Integer recId) {
        return patientService.getPatientsByReceptionist(recId);
    }

    // Count patients of a doctor
    @GetMapping("/count/doctor/{doctorId}")
    public Long countPatients(@PathVariable Integer doctorId) {
        return patientService.countPatientsByDoctor(doctorId);
    }

    // Assign doctor
    @PutMapping("/assign-doctor/{patientId}/{doctorId}")
    public PatientDTO assignDoctor(@PathVariable Integer patientId, @PathVariable Integer doctorId) {
        return patientService.assignDoctor(patientId, doctorId);
    }

    // Assign receptionist
    @PutMapping("/assign-receptionist/{patientId}/{recId}")
    public PatientDTO assignReceptionist(@PathVariable Integer patientId, @PathVariable Integer recId) {
        return patientService.assignReceptionist(patientId, recId);
    }
    
    //sort patients 
    @GetMapping("/sorted/{field}")
    public List<PatientDTO> getSortedPatients(@PathVariable String field) {
        return patientService.getAllPatientsSorted(field);
    }


}
