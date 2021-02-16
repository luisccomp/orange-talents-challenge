package br.com.luisccomp.orangetalentschallenge.domain.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class VaccineUpdateRequestDTO {

    @JsonProperty("name")
    @NotBlank
    private String name;

    @JsonProperty("realizationDate")
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate realizationDate;

    public VaccineUpdateRequestDTO() {

    }

    public VaccineUpdateRequestDTO(@NotBlank String name, @NotNull LocalDate realizationDate) {
        this.name = name;
        this.realizationDate = realizationDate;
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
}
