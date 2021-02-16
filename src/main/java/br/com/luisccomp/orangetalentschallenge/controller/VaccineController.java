package br.com.luisccomp.orangetalentschallenge.controller;

import br.com.luisccomp.orangetalentschallenge.domain.model.request.VaccineCreateRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.request.VaccineUpdateRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.response.VaccineResponseDTO;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/vaccines")
public interface VaccineController {

    @PostMapping
    ResponseEntity<VaccineResponseDTO> createVaccine(@RequestBody @Valid VaccineCreateRequestDTO vaccineCreateRequest);

    @GetMapping
    ResponseEntity<Page<VaccineResponseDTO>> findAllVaccines(
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String name,
            Pageable pageable
    );

    @GetMapping("/{id}")
    ResponseEntity<VaccineResponseDTO> findVaccineById(@PathVariable Long id);

    @PatchMapping("/{id}")
    ResponseEntity<VaccineResponseDTO> updateVaccine(@PathVariable Long id, @RequestBody @Valid VaccineUpdateRequestDTO vaccineUpdateRequest);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteVaccine(@PathVariable Long id);

}
