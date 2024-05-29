package cz.solarik.knihkupectvi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Uzivatel {
    @Id
    @Column
    private Long id;

    @Column
    private String nickname;

    @Column
    private String password;

    @Column
    private String email;
}

