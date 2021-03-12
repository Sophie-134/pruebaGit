package cl.acn.lab.demo.dto;

import lombok.Data;


@Data
public class SearchDTO {

    private Long id;
    private String name;
    private String authorName;
    private String genre;
    private String videoLink;

}
