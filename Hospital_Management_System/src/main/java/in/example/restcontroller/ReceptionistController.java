package in.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.example.dto.ReceptionistDTO;
import in.example.service.ReceptionistService;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

    @Autowired
    private ReceptionistService receptionistService;

    // ========== CREATE ==========
    @PostMapping("/save")
    public ReceptionistDTO saveReceptionist(@RequestBody ReceptionistDTO dto) {
        return receptionistService.saveReceptionist(dto);
    }

    // ========== UPDATE ==========
    @PutMapping("/update")
    public ReceptionistDTO updateReceptionist(@RequestBody ReceptionistDTO dto) {
        return receptionistService.updateReceptionist(dto);
    }

    // ========== DELETE ==========
    @DeleteMapping("/delete/{id}")
    public String deleteReceptionist(@PathVariable Integer id) {
        receptionistService.deleteReceptionist(id);
        return "Receptionist deleted successfully with ID: " + id;
    }

    // ========== GET BY ID ==========
    @GetMapping("/get/{id}")
    public ReceptionistDTO getReceptionistById(@PathVariable Integer id) {
        return receptionistService.getReceptionistById(id);
    }

    // ========== GET ALL ==========
    @GetMapping("/all")
    public List<ReceptionistDTO> getAllReceptionists() {
        return receptionistService.getAllReceptionists();
    }
}
