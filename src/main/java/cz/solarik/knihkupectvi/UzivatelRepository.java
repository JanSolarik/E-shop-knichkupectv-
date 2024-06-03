package cz.solarik.knihkupectvi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.solarik.knihkupectvi.Uzivatel;

import java.util.Optional;

@Repository
public interface UzivatelRepository extends JpaRepository<Uzivatel, Long> {

    Optional<Uzivatel> findByUsername(String username);
}
