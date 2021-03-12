package cl.acn.lab.demo.service;

import java.util.List;

import cl.acn.lab.demo.dto.CommentDTO;

public interface CommentService {

    public List<CommentDTO> getAll();

    public CommentDTO getById(Long id);

    public boolean save(List<CommentDTO> input);

    public boolean update(List<CommentDTO> input);

    public boolean delete(Long id);
}
