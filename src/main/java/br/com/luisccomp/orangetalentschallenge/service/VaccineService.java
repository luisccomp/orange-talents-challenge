package br.com.luisccomp.orangetalentschallenge.service;

import br.com.luisccomp.orangetalentschallenge.domain.model.request.VaccineCreateRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.request.VaccineUpdateRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.response.VaccineResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VaccineService {
    VaccineResponseDTO createVaccine(VaccineCreateRequestDTO vaccineCreateRequest);

    Page<VaccineResponseDTO> findAllVaccines(String cpf, String name, Pageable pageable);

    VaccineResponseDTO findVaccineById(Long id);

    VaccineResponseDTO updateVaccine(Long id, VaccineUpdateRequestDTO vaccineUpdateRequest);

    void deleteVaccine(Long id);
}
