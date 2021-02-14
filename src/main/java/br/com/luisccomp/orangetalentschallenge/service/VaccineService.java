package br.com.luisccomp.orangetalentschallenge.service;

import br.com.luisccomp.orangetalentschallenge.domain.model.request.VaccineRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.request.VaccineUpdateRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.response.VaccineResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VaccineService {
    VaccineResponseDTO createVaccine(VaccineRequestDTO vaccineCreateRequest);

    Page<VaccineResponseDTO> findAllVaccines(Pageable pageable);

    VaccineResponseDTO findVaccineById(Long id);

    VaccineResponseDTO updateVaccine(Long id, VaccineUpdateRequestDTO vaccineUpdateRequest);

    void deleteVaccine(Long id);
}
