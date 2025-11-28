package br.com.smartorder.clientservice.service;

import br.com.smartorder.clientservice.dto.UserRequestDto;
import br.com.smartorder.clientservice.dto.UserResponseDto;
import br.com.smartorder.clientservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto create(UserRequestDto request) {
        return new UserResponseDto(userRepository.save(request.toEntity()));
    }

}


