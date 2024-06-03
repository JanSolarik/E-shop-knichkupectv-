package cz.solarik.knihkupectvi;

import jakarta.persistence.*;

@Entity
@Table
public class Uzivatel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        // Tenhle konstruktor je pro programatori
        this.username = username;
    }

    public Long getId() {
        return id;
    }
}


