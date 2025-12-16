package in.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.example.dto.ReceptionistDTO;
import in.example.entity.Receptionist;
import in.example.mapper.HospitalMapper;
import in.example.repository.ReceptionistRepository;

@Service
public class ReceptionistServiceImpl implements ReceptionistService {

    @Autowired
    private ReceptionistRepository receptionistRepository;

    @Autowired
    private HospitalMapper mapper;

    @Override
    public ReceptionistDTO saveReceptionist(ReceptionistDTO dto) {
        Receptionist receptionist = mapper.toReceptionistEntity(dto);
        Receptionist saved = receptionistRepository.save(receptionist);
        return mapper.toReceptionistDTO(saved);
    }

    @Override
    public ReceptionistDTO updateReceptionist(ReceptionistDTO dto) {
        Receptionist receptionist = mapper.toReceptionistEntity(dto);
        Receptionist updated = receptionistRepository.save(receptionist);
        return mapper.toReceptionistDTO(updated);
    }

    @Override
    public void deleteReceptionist(Integer id) {
        receptionistRepository.deleteById(id);
    }

    @Override
    public ReceptionistDTO getReceptionistById(Integer id) {
        return receptionistRepository.findById(id)
                .map(mapper::toReceptionistDTO)
                .orElse(null);
    }

    @Override
    public List<ReceptionistDTO> getAllReceptionists() {
        return receptionistRepository.findAll()
                .stream()
                .map(mapper::toReceptionistDTO)
                .collect(Collectors.toList());
    }
}
