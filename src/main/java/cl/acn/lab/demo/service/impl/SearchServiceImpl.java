package cl.acn.lab.demo.service.impl;

import cl.acn.lab.demo.dto.SearchDTO;
import cl.acn.lab.demo.entity.Search;
import cl.acn.lab.demo.repository.SearchRepository;
import cl.acn.lab.demo.service.SearchService;
import cl.acn.lab.demo.utils.MapperUtils;
import lombok.extern.log4j.Log4j;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("searchService")
@Log4j
public class SearchServiceImpl implements SearchService {


    @Autowired
    @Qualifier("searchRepository")
    private SearchRepository searchRepo;

    @Override
    public List<SearchDTO> getAll() {
        return (List<SearchDTO>) MapperUtils.mapAsList(searchRepo.getAll(), new TypeToken<List<SearchDTO>>() {
        }.getType());
    }

    @Override
    public SearchDTO getById(Long id) {
        Optional<Search> data = this.searchRepo.findById(id);
        if (data.isPresent()) {
            return (SearchDTO) MapperUtils.map(data, SearchDTO.class);
        } else {
            return null;
        }
    }

   

    @Override
    public boolean save(List<SearchDTO> daoList) {
        boolean result=Boolean.FALSE;
        try {
            List<Search> entityList = (List<Search>) MapperUtils.mapAsList(daoList, new TypeToken<List<Search>>() {
            }.getType());

            List<Search> saveResult = this.searchRepo.saveAll(entityList);
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
    public boolean update(List<SearchDTO> daoList) {
        boolean result=Boolean.FALSE;
        try {
            List<Search> entityList = (List<Search>) MapperUtils.mapAsList(daoList, new TypeToken<List<Search>>() {
            }.getType());

            List<Search> saveResult = this.searchRepo.saveAll(entityList);
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
            this.searchRepo.deleteById(id);
            ret = true;
        } catch (Exception e) {
            log.error("ERROR message:  " + e.getMessage());
        }
        return ret;
    }
}


