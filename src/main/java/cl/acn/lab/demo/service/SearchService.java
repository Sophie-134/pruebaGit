package cl.acn.lab.demo.service;

import cl.acn.lab.demo.dto.SearchDTO;
import java.util.List;

public interface SearchService {

    public List<SearchDTO> getAll();

    public SearchDTO getById(Long id);

    public boolean save(List<SearchDTO> input);

    public boolean update(List<SearchDTO> input);

    public boolean delete(Long id);

}
