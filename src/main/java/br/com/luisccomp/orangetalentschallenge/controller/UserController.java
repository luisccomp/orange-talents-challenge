package br.com.luisccomp.orangetalentschallenge.controller;

import br.com.luisccomp.orangetalentschallenge.domain.model.request.UserRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.response.UserResponseDTO;
import java.time.LocalDate;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/users")
public interface UserController {

    @PostMapping
    ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO userCreateRequest);

    @GetMapping
    ResponseEntity<Page<UserResponseDTO>> findAllUsers(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate,
            Pageable pageable
    );

    @GetMapping("/{id}")
    ResponseEntity<UserResponseDTO> findUserById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequestDTO userUpdateRequest);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id);

}
