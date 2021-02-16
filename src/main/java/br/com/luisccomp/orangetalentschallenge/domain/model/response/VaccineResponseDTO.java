package br.com.luisccomp.orangetalentschallenge.domain.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDate;

@JsonPropertyOrder({"id", "name", "realizationDate", "user"})
public class VaccineResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("realizationDate")
    private LocalDate realizationDate;

    @JsonProperty("user")
    private UserResponseDTO user;

    public VaccineResponseDTO() {

    }

    public VaccineResponseDTO(Long id, String name, LocalDate realizationDate, UserResponseDTO user) {
        this.id = id;
        this.name = name;
        this.realizationDate = realizationDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(LocalDate realizationDate) {
        this.realizationDate = realizationDate;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }

}
