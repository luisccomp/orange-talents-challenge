package br.com.luisccomp.orangetalentschallenge.service;

import br.com.luisccomp.orangetalentschallenge.domain.model.entity.User;
import br.com.luisccomp.orangetalentschallenge.domain.model.request.UserRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.response.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO userCreateRequest);

    Page<UserResponseDTO> findAllUsers(Pageable pageable);

    UserResponseDTO findUserById(Long id);

    UserResponseDTO updateUser(Long id, UserRequestDTO userUpdateRequest);

    void deleteUser(Long id);

    User getUserById(Long id);

}
