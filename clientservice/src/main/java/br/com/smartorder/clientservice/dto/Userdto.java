package br.com.smartorder.clientservice.dto;

import jakarta.validation.constraints.NotBlank;

public record Userdto(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String password
) {
}
