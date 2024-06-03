package cz.solarik.knihkupectvi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Uzivatel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <--- ID nechame vygenerovat databazi
    @Column
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    protected Uzivatel() {
        // Tenhle konstruktor je nutny pro Spring (Hibernate)
    }

    public Uzivatel(String username) {
        // Tenhle konstruktor je pro programatora
        this.username = username;
    }

    // Potrebujeme getter
    public Long getId() {
        return id;
    }
}
