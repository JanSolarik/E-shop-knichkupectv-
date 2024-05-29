package cz.solarik.knihkupectvi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class author {
    @Id
    @Column
    private long id;

    @Column
    private String nickname;

    @Column
    private String book;
}
