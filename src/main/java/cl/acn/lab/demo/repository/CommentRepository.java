package cl.acn.lab.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.acn.lab.demo.entity.Comment;

@Repository("commentRepository")
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM COMMENT", nativeQuery = true)
    public List<Comment> getAll();
}