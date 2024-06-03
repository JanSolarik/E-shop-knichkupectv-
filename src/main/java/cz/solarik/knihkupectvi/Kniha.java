package cz.solarik.knihkupectvi;

import jakarta.persistence.*;

@Entity
@Table
public class Kniha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String bookName;

    @Column
    private String author;

    protected Kniha() {
    }
    public Kniha(String bookName,String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public Long getId() {
        return id;
    }
}
