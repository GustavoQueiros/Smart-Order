package br.com.smartorder.clientservice.dto;

import br.com.smartorder.clientservice.entity.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    @NotBlank private String name;
    @NotBlank @Email private String email;
    @NotBlank private String password;

    public UserEntity toEntity(){
        return new UserEntity(
                this.name,
                this.email,
                this.password
        );
    }

}
