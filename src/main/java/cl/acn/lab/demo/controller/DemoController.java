package cl.acn.lab.demo.controller;

import cl.acn.lab.demo.dto.SearchDTO;
import cl.acn.lab.demo.service.SearchService;
import com.google.gson.Gson;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ACN-lab
 * Date: 09-08-20
 */

@Controller
@RequestMapping("/search")
@Api(value="Demo_Controller", description="Demo Controller")
@Log4j
public class DemoController {

    @Autowired
    @Qualifier("searchService")
    private SearchService searchService;


    /**GET BY ID**/
    @GetMapping(value = "example/{code}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Ejemplo de operación GET by ID", response = SearchDTO.class, responseContainer = "", notes = "Returns a ExampleDTO Object")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success return ExampleDTO object", response = SearchDTO.class ),
            @ApiResponse(code = 204, message = "No content, without content for the query", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error, Exception message")
    })
    public ResponseEntity<?> exampleGetById(@PathVariable("code") String code) {
        log.info("######  ENTRADA A GET BY ID EXAMPLE |  CODE : " + code);
        ResponseEntity<?> response =null;
        SearchDTO responseData = this.searchService.getById(Long.parseLong(code));

        try {
            if(responseData!=null) {
                response =  new ResponseEntity<>(responseData, HttpStatus.OK);
            }else {
                response = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        log.info("######  SALIDA DE GET BY ID EXAMPLE");
        return response;
    }
    

    

    /**GET - ALL**/
    @GetMapping(value = "example", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Ejemplo de operación GET - ALL", response = SearchDTO.class, responseContainer = "List<>", notes = "Returns a List<ExampleDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success return a list of ExampleDTO object", response = SearchDTO.class ),
            @ApiResponse(code = 204, message = "No content, without content for the query", response = String.class ),
            @ApiResponse(code = 500, message = "Internal Server Error, Exception message")
    })
    public ResponseEntity<List<SearchDTO>> exampleGetAll() {
        log.info("######  ENTRADA A GET ALL EXAMPLE");
        ResponseEntity<List<SearchDTO>> response =null;
        List<SearchDTO> responseData = this.searchService.getAll();
        try {
            if(responseData!=null) {
                response =  new ResponseEntity<>(responseData, HttpStatus.OK);
            }else {
                response = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        }catch (Exception e) {
            response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("######  SALIDA DE GET ALL EXAMPLE");
        return response;
    }

}