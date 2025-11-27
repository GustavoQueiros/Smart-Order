package br.com.smartorder.clientservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "USERS")
@Entity
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Column(name = "NAME")
    private String name;

    @Email(message = "Invalid E-mail")
    @Column(name = "EMAIL")
    @NotBlank
    private String email;

    @NotBlank
    @Column(name = "PASSWORD")
    private String password;

}
