package cl.acn.lab.demo.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "SEARCH")
public class Search {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String name;

    @Column(name = "NOMBRE_AUTOR", nullable = false)
    private String authorName;

    @Column(name = "GENERO", nullable = false)
    private String genre;

    @Column(name = "LINK_DEL_VIDEO", nullable = false)
    private String videoLink;
}
