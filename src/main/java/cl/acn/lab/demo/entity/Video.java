package cl.acn.lab.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "VIDEO")
public class Video {

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
