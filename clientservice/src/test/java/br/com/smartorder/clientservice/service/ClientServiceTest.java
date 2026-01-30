package br.com.smartorder.clientservice.service;

import br.com.smartorder.clientservice.dto.UserRequestDto;
import br.com.smartorder.clientservice.dto.UserResponseDto;
import br.com.smartorder.clientservice.entity.UserEntity;
import br.com.smartorder.clientservice.exception.EmailAlreadyUsedException;
import br.com.smartorder.clientservice.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) //Ativa o Mockito no JUnit 5
public class ClientServiceTest {

    @Mock //cria um mock das classes que vão depender da repository
    UserRepository repository;

    @InjectMocks //A UserService depende da UserRepository, então injetamos o mock aqui, injeta o mock da repository na classe userService
    UserService userService;

    @Test
    @DisplayName("Creating a user sucess")
    public void creating_user_sucess() throws EmailAlreadyUsedException {

        //GIVEN
        UserRequestDto request = new UserRequestDto("Gustavo", "gustavo@email.com", "senha123");
        when(repository.findByEmail("gustavo@email.com")).thenReturn(Optional.empty());//quando o metodo de buscar por email for chamado, ele já vai retornar vazio, com o email gustavo@email.com

        UserEntity entity = request.toEntity();

        when(repository.save(any(UserEntity.class))).thenReturn(entity);

        //WHEN
        UserResponseDto response = userService.create(request);

        //THEN - validação do retorno
        assertNotNull(response);
        assertEquals("Gustavo", response.getName());
        assertEquals("gustavo@email.com", response.getEmail());


        //THEN - Valida comportamento
        verify(repository).findByEmail("gustavo@email.com");
        verify(repository).save(any(UserEntity.class));
    }
}
