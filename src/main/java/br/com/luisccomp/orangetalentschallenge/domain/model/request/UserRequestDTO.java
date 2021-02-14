package br.com.luisccomp.orangetalentschallenge.domain.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

public class UserRequestDTO {

    @JsonProperty("name")
    @NotBlank
    private String name;

    @JsonProperty("cpf")
    @CPF
    private String cpf;

    @JsonProperty("email")
    @NotEmpty
    @Email
    private String email;

    @JsonProperty("birthdate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate birthdate;

    public UserRequestDTO() {

    }

    public UserRequestDTO(String name, String cpf, String email, LocalDate birthdate) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

}
