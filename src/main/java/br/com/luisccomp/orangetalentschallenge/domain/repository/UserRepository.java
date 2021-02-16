package br.com.luisccomp.orangetalentschallenge.domain.repository;

import br.com.luisccomp.orangetalentschallenge.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

}
