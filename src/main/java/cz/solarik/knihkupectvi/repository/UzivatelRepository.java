package cz.solarik.knihkupectvi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.solarik.knihkupectvi.Uzivatel;

import java.util.Optional;

// Tohle repository slouzi pro praci s entitou Uzivatel
// Napr. ulozeni objektu Uzivatel do databaze nebo vytahnouti podle ID
@Repository
public interface UzivatelRepository extends JpaRepository<Uzivatel, Long> {

    Optional<Uzivatel> findByUsername(String username);
}
