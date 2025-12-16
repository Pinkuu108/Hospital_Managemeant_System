package in.example.service;

import java.util.List;
import in.example.dto.ReceptionistDTO;

public interface ReceptionistService {

    ReceptionistDTO saveReceptionist(ReceptionistDTO dto);

    ReceptionistDTO updateReceptionist(ReceptionistDTO dto);

    void deleteReceptionist(Integer id);

    ReceptionistDTO getReceptionistById(Integer id);

    List<ReceptionistDTO> getAllReceptionists();
}
