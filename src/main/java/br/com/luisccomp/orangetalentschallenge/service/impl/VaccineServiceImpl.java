package br.com.luisccomp.orangetalentschallenge.service.impl;

import br.com.luisccomp.orangetalentschallenge.core.mapper.ClassMapper;
import br.com.luisccomp.orangetalentschallenge.domain.model.entity.Vaccine;
import br.com.luisccomp.orangetalentschallenge.domain.model.request.VaccineCreateRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.request.VaccineUpdateRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.response.VaccineResponseDTO;
import br.com.luisccomp.orangetalentschallenge.domain.repository.VaccineRepository;
import br.com.luisccomp.orangetalentschallenge.exception.NotFoundException;
import br.com.luisccomp.orangetalentschallenge.service.UserService;
import br.com.luisccomp.orangetalentschallenge.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static br.com.luisccomp.orangetalentschallenge.domain.repository.specifications.VaccineSpecifications.hasNameLike;
import static br.com.luisccomp.orangetalentschallenge.domain.repository.specifications.VaccineSpecifications.hasUserWithCpf;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;
    private final ClassMapper classMapper;    
    private final UserService userService;

    @Autowired
    public VaccineServiceImpl(VaccineRepository vaccineRepository, ClassMapper classMapper, UserService userService) {
        this.vaccineRepository = vaccineRepository;
        this.classMapper = classMapper;
        this.userService = userService;
    }    

    @Override
    public VaccineResponseDTO createVaccine(VaccineCreateRequestDTO vaccineCreateRequest) {
        var user = userService.getUserById(vaccineCreateRequest.getUserId());

        var vaccine = classMapper.map(vaccineCreateRequest, Vaccine.class);
        vaccine.setUser(user);

        return classMapper.map(vaccineRepository.save(vaccine), VaccineResponseDTO.class);
    }

    @Override
    public Page<VaccineResponseDTO> findAllVaccines(String cpf, String name, Pageable pageable) {
        return vaccineRepository.findAll(
                where(hasUserWithCpf(cpf))
                        .and(where(hasNameLike(name))),
                pageable
        )
                .map(vaccine -> classMapper.map(vaccine, VaccineResponseDTO.class));
    }

    @Override
    public VaccineResponseDTO findVaccineById(Long id) {
        var vaccine = vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vaccine not found"));

        return classMapper.map(vaccine, VaccineResponseDTO.class);
    }

    @Override
    public VaccineResponseDTO updateVaccine(Long id, VaccineUpdateRequestDTO vaccineUpdateRequest) {
        var vaccine = vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vaccine not found"));

        vaccine.setName(vaccineUpdateRequest.getName());
        vaccine.setRealizationDate(vaccineUpdateRequest.getRealizationDate());

        return classMapper.map(vaccineRepository.save(vaccine), VaccineResponseDTO.class);
    }

    @Override
    public void deleteVaccine(Long id) {
        var vaccine = vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vaccine not found"));

        vaccineRepository.delete(vaccine);
    }

}
