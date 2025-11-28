package br.com.smartorder.clientservice.controller;


import br.com.smartorder.clientservice.dto.UserRequestDto;
import br.com.smartorder.clientservice.dto.UserResponseDto;
import br.com.smartorder.clientservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody @Valid UserRequestDto request){
        return ResponseEntity.ok(userService.create(request));
    }


}
