package br.com.luisccomp.orangetalentschallenge.controller.impl;

import br.com.luisccomp.orangetalentschallenge.controller.UserController;
import br.com.luisccomp.orangetalentschallenge.domain.model.request.UserRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.response.UserResponseDTO;
import br.com.luisccomp.orangetalentschallenge.service.UserService;
import java.net.URI;
import java.time.LocalDate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserResponseDTO> createUser(@Valid UserRequestDTO userCreateRequest) {
        var response = userService.createUser(userCreateRequest);

        var uri = URI.create("/api/users/" + response.getId());

        return ResponseEntity.created(uri)
                .body(response);
    }

    @Override
    public ResponseEntity<Page<UserResponseDTO>> findAllUsers(LocalDate fromDate, LocalDate toDate, Pageable pageable) {
        return ResponseEntity.ok(userService.findAllUsers(fromDate, toDate, pageable));
    }

    @Override
    public ResponseEntity<UserResponseDTO> findUserById(Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @Override
    public ResponseEntity<UserResponseDTO> updateUser(Long id, @Valid UserRequestDTO userUpdateRequest) {
        return ResponseEntity.ok(userService.updateUser(id, userUpdateRequest));
    }

    @Override
    public ResponseEntity<?> deleteUser(Long id) {
        userService.deleteUser(id);

        return ResponseEntity.noContent()
                .build();
    }

}
