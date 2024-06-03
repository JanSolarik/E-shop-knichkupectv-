package cz.solarik.knihkupectvi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnihaRepository extends JpaRepository<Kniha, Long> {
}
