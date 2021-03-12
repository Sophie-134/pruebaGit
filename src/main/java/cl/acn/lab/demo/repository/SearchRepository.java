package cl.acn.lab.demo.repository;

import cl.acn.lab.demo.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("searchRepository")
public interface SearchRepository extends JpaRepository<Search, Long> {

    @Query(value = "SELECT * FROM SEARCH", nativeQuery = true)
    public List<Search> getAll();
    
    
}
