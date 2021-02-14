package br.com.luisccomp.orangetalentschallenge.service.impl;

import br.com.luisccomp.orangetalentschallenge.domain.model.entity.User;
import br.com.luisccomp.orangetalentschallenge.domain.model.request.UserRequestDTO;
import br.com.luisccomp.orangetalentschallenge.domain.model.response.UserResponseDTO;
import br.com.luisccomp.orangetalentschallenge.domain.repository.UserRepository;
import br.com.luisccomp.orangetalentschallenge.exception.BadRequestException;
import br.com.luisccomp.orangetalentschallenge.exception.NotFoundException;
import br.com.luisccomp.orangetalentschallenge.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userCreateRequest) {
        if (userRepository.existsByCpf(userCreateRequest.getCpf()) ||
                userRepository.existsByEmail(userCreateRequest.getEmail()))
            throw new BadRequestException("User email or CPF must be unique");

        var user = modelMapper.map(userCreateRequest, User.class);

        return modelMapper.map(userRepository.save(user), UserResponseDTO.class);
    }

    @Override
    public Page<UserResponseDTO> findAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(user -> modelMapper.map(user, UserResponseDTO.class));
    }

    @Override
    public UserResponseDTO findUserById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userUpdateRequest) {
        if (userRepository.existsByCpf(userUpdateRequest.getCpf()) ||
                userRepository.existsByCpf(userUpdateRequest.getCpf()))
            throw new BadRequestException("User email or CPF must be unique");

        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        user.setName(user.getName());
        user.setCpf(user.getCpf());
        user.setEmail(user.getEmail());
        user.setBirthdate(user.getBirthdate());

        return modelMapper.map(userRepository.save(user), UserResponseDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        userRepository.delete(user);
    }

}
