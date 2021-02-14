package br.com.luisccomp.orangetalentschallenge.domain.repository;

import br.com.luisccomp.orangetalentschallenge.domain.model.entity.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

    @Query("select v " +
           "from Vaccine v " +
           "join v.user user " +
           "where user.id = :userId")
    Page<Vaccine> findAllUserVaccines(@Param("userId") Long userId, Pageable pageable);

}
