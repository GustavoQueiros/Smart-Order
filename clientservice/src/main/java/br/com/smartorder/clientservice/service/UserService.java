package br.com.smartorder.clientservice.service;

import br.com.smartorder.clientservice.dto.UserRequestDto;
import br.com.smartorder.clientservice.dto.UserResponseDto;
import br.com.smartorder.clientservice.entity.UserEntity;
import br.com.smartorder.clientservice.exception.EmailAlreadyUsedException;
import br.com.smartorder.clientservice.exception.UserNotFoundException;
import br.com.smartorder.clientservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}


