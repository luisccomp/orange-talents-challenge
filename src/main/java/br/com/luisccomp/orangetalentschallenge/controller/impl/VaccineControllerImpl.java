package br.com.luisccomp.orangetalentschallenge.controller.impl;

import br.com.luisccomp.orangetalentschallenge.controller.VaccineController;
import br.com.luisccomp.orangetalentschallenge.domain.model.request.VaccineCreateRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.request.VaccineUpdateRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.response.VaccineResponseDTO;
import br.com.luisccomp.orangetalentschallenge.service.VaccineService;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaccineControllerImpl implements VaccineController {

    private final VaccineService vaccineService;

    @Autowired
    public VaccineControllerImpl(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @Override
    public ResponseEntity<VaccineResponseDTO> createVaccine(@Valid VaccineCreateRequestDTO vaccineCreateRequest) {
        var vaccine = vaccineService.createVaccine(vaccineCreateRequest);

        var uri = URI.create("/api/vaccines/" + vaccine.getId());

        return ResponseEntity.created(uri)
                .body(vaccine);
    }

    @Override
    public ResponseEntity<Page<VaccineResponseDTO>> findAllVaccines(String cpf, String name, Pageable pageable) {
        return ResponseEntity.ok(vaccineService.findAllVaccines(cpf, name, pageable));
    }

    @Override
    public ResponseEntity<VaccineResponseDTO> findVaccineById(Long id) {
        return ResponseEntity.ok(vaccineService.findVaccineById(id));
    }

    @Override
    public ResponseEntity<VaccineResponseDTO> updateVaccine(Long id, @Valid VaccineUpdateRequestDTO vaccineUpdateRequest) {
        return ResponseEntity.ok(vaccineService.updateVaccine(id, vaccineUpdateRequest));
    }

    @Override
    public ResponseEntity<?> deleteVaccine(Long id) {
        vaccineService.deleteVaccine(id);

        return ResponseEntity.noContent()
                .build();
    }

}
