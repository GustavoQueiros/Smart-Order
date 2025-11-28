package br.com.smartorder.clientservice.dto;

import br.com.smartorder.clientservice.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;

    public UserResponseDto(UserEntity user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
