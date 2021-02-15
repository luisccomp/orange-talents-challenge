package br.com.luisccomp.orangetalentschallenge.domain.repository.specifications;

import br.com.luisccomp.orangetalentschallenge.domain.model.entity.Vaccine;
import org.springframework.data.jpa.domain.Specification;

public class VaccineSpecifications {

    public static Specification<Vaccine> hasUserWithCpf(String cpf) {
        if (cpf != null) {
            return (vaccine, query, builder) -> builder.equal(vaccine.get("user").get("cpf"), cpf);
        } else {
            return  null;
        }
    }

    public static Specification<Vaccine> hasNameLike(String name) {
        if (name != null) {
        return (vaccine, query, builder) -> builder.like(vaccine.get("name"), "%" + name + "%");
        } else {
            return null;
        }
    }

}
