package br.com.luisccomp.orangetalentschallenge.domain.repository.specifications;

import br.com.luisccomp.orangetalentschallenge.domain.model.entity.User;
import java.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {

    public static Specification<User> fromBirthdate(LocalDate birthdate) {
        if (birthdate != null) {
            return (user, query, builder) -> builder.greaterThanOrEqualTo(user.get("birthdate"), birthdate);
        } else {
            return null;
        }
    }

    public static Specification<User> toBirthdate(LocalDate birthdate) {
        if (birthdate != null) {
            return (user, query, builder) -> builder.lessThanOrEqualTo(user.get("birthdate"), birthdate);
        } else {
            return null;
        }
    }

}
