package br.com.smartorder.clientservice.controller;


import br.com.smartorder.clientservice.dto.UserRequestDto;
import br.com.smartorder.clientservice.dto.UserResponseDto;
import br.com.smartorder.clientservice.exception.EmailAlreadyUsedException;
import br.com.smartorder.clientservice.exception.UserNotFoundException;
import br.com.smartorder.clientservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody @Valid UserRequestDto request) throws EmailAlreadyUsedException {
        return ResponseEntity.ok(userService.create(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws UserNotFoundException {

        userService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
