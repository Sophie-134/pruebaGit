package cl.acn.lab.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.acn.lab.demo.dto.CommentDTO;
import cl.acn.lab.demo.dto.VideoDTO;
import cl.acn.lab.demo.entity.Comment;
import cl.acn.lab.demo.entity.Video;
import cl.acn.lab.demo.repository.CommentRepository;
import cl.acn.lab.demo.service.CommentService;
import cl.acn.lab.demo.utils.MapperUtils;
import lombok.extern.log4j.Log4j;

@Service("commentService")
@Log4j
public class CommentServiceImpl implements CommentService {


    @Autowired
    @Qualifier("commentRepository")
    private CommentRepository commentRepository;

    @Override
    public List<CommentDTO> getAll() {
        return (List<CommentDTO>) MapperUtils.mapAsList(commentRepository.getAll(), new TypeToken<List<CommentDTO>>() {
        }.getType());
    }

    @Override
    public CommentDTO getById(Long id) {
        Optional<Comment> data = this.commentRepository.findById(id);
        if (data.isPresent()) {
            return (CommentDTO) MapperUtils.map(data, CommentDTO.class);
        } else {
            return null;
        }


    }
    
    @Override
    public boolean save(List<CommentDTO> daoList) {
        boolean result=Boolean.FALSE;
        try {
            List<Comment> entityList = (List<Comment>) MapperUtils.mapAsList(daoList, new TypeToken<List<Comment>>() {
            }.getType());

            List<Comment> saveResult = this.commentRepository.saveAll(entityList);
            if (saveResult.size() == entityList.size()) {
                result= Boolean.TRUE;
            } else {
                result= Boolean.FALSE;
            }
        }catch(Exception e){
            log.error("ERROR message:  " + e.getMessage());
        }
        return result;
    } 

    @Override
    public boolean update(List<CommentDTO> daoList) {
        boolean result=Boolean.FALSE;
        try {
            List<Comment> entityList = (List<Comment>) MapperUtils.mapAsList(daoList, new TypeToken<List<Comment>>() {
            }.getType());

            List<Comment> saveResult = this.commentRepository.saveAll(entityList);
            if (saveResult.size() == entityList.size()) {
                result= Boolean.TRUE;
            } else {
                result= Boolean.FALSE;
            }
        }catch(Exception e){
            log.error("ERROR message:  " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean delete(Long id) {
        boolean ret = false;
        try {
            this.commentRepository.deleteById(id);
            ret = true;
        } catch (Exception e) {
            log.error("ERROR message:  " + e.getMessage());
        }
        return ret;
    }
}


