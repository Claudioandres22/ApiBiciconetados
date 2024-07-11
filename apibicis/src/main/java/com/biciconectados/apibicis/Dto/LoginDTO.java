package com.biciconectados.apibicis.Dto;



import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
public class LoginDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}