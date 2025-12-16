package in.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.example.dto.DoctorDTO;
import in.example.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // ========== CREATE ==========
    @PostMapping("/save")
    public DoctorDTO saveDoctor(@RequestBody DoctorDTO dto) {
        return doctorService.saveDoctor(dto);
    }

    // ========== UPDATE ==========
    @PutMapping("/update")
    public DoctorDTO updateDoctor(@RequestBody DoctorDTO dto) {
        return doctorService.updateDoctor(dto);
    }

    // ========== DELETE ==========
    @DeleteMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
        return "Doctor deleted successfully with ID: " + id;
    }

    // ========== GET BY ID ==========
    @GetMapping("/get/{id}")
    public DoctorDTO getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }

    // ========== GET ALL ==========
    @GetMapping("/all")
    public List<DoctorDTO> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
    
 // Search doctors by specialization
    @GetMapping("/specialization/{spec}")
    public List<DoctorDTO> findDoctorsBySpec(@PathVariable String spec) {
        return doctorService.getDoctorsBySpecialization(spec);
    }

}
