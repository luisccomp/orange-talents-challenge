package br.com.luisccomp.orangetalentschallenge.service.impl;

import br.com.luisccomp.orangetalentschallenge.core.mapper.ClassMapper;
import br.com.luisccomp.orangetalentschallenge.domain.model.entity.User;
import br.com.luisccomp.orangetalentschallenge.domain.model.request.UserRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.response.UserResponseDTO;
import br.com.luisccomp.orangetalentschallenge.domain.repository.UserRepository;
import br.com.luisccomp.orangetalentschallenge.exception.BadRequestException;
import br.com.luisccomp.orangetalentschallenge.exception.NotFoundException;
import br.com.luisccomp.orangetalentschallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ClassMapper classMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ClassMapper classMapper) {
        this.userRepository = userRepository;
        this.classMapper = classMapper;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userCreateRequest) {
        if (userRepository.existsByCpf(userCreateRequest.getCpf()) ||
                userRepository.existsByEmail(userCreateRequest.getEmail()))
            throw new BadRequestException("User email or CPF must be unique");

        var user = classMapper.map(userCreateRequest, User.class);

        return classMapper.map(userRepository.save(user), UserResponseDTO.class);
    }

    @Override
    public Page<UserResponseDTO> findAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(user -> classMapper.map(user, UserResponseDTO.class));
    }

    @Override
    public UserResponseDTO findUserById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        return classMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userUpdateRequest) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        if (!user.getCpf().equals(userUpdateRequest.getCpf()) && userRepository.existsByCpf(userUpdateRequest.getCpf()) ||
                !user.getEmail().equals(userUpdateRequest.getEmail()) && userRepository.existsByCpf(userUpdateRequest.getCpf()))
            throw new BadRequestException("User email or CPF must be unique");

        user.setName(user.getName());
        user.setCpf(user.getCpf());
        user.setEmail(user.getEmail());
        user.setBirthdate(user.getBirthdate());

        return classMapper.map(userRepository.save(user), UserResponseDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        userRepository.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

}
