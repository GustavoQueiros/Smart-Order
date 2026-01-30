package br.com.smartorder.clientservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "USERS")
@Entity
@NoArgsConstructor
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Email(message = "Invalid E-mail")
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    // NOTBLANK PODE SER USADO COMO DICA DENTRO DO CODIGO PARA INFORMAR QUE DETERMINADO ATRIBUTO DEVE SER INFORMADO CORRETAMENTE
    public UserEntity(@NotBlank String name, @NotBlank @Email String email, @NotBlank String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
