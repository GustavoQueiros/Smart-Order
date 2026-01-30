package br.com.smartorder.clientservice.service;

import br.com.smartorder.clientservice.dto.UserRequestDto;
import br.com.smartorder.clientservice.dto.UserResponseDto;
import br.com.smartorder.clientservice.entity.UserEntity;
import br.com.smartorder.clientservice.exception.EmailAlreadyUsedException;
import br.com.smartorder.clientservice.exception.UserNotFoundException;
import br.com.smartorder.clientservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto create(UserRequestDto request) throws EmailAlreadyUsedException {

        Optional<UserEntity> user = userRepository.findByEmail(request.getEmail());

        if (user.isEmpty()) {
            return new UserResponseDto(userRepository.save(request.toEntity()));
        }
        throw new EmailAlreadyUsedException();
    }

    public void delete(Long id) throws UserNotFoundException {

        UserEntity user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        userRepository.delete(user);

    }

    public List<UserResponseDto> getAll() {

        return userRepository.findAll().stream().map(UserResponseDto::new).toList();

    }

    public UserResponseDto updateUser(UserRequestDto request, Long id) throws UserNotFoundException {

        UserEntity user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return new UserResponseDto(user);

    }

    //para amanhã 09-12 é testar se esse metodo de atualizar esta correto

}


