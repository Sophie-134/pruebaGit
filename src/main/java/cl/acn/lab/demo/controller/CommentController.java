package cl.acn.lab.demo.controller;

import java.util.List;

import cl.acn.lab.demo.dto.CommentDTO;
import cl.acn.lab.demo.service.CommentService;
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


@Controller
@RequestMapping("/comment")
@Api(value="Demo_Controller", description="Demo Controller")
@Log4j
public class CommentController {

    @Autowired
    @Qualifier("commentService")
    private CommentService commentService;


    /**GET BY ID**/
    @GetMapping(value = "example/{code}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Ejemplo de operación GET by ID", response = CommentDTO.class, responseContainer = "", notes = "Returns a ExampleDTO Object")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success return ExampleDTO object", response = CommentDTO.class ),
            @ApiResponse(code = 204, message = "No content, without content for the query", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error, Exception message")
    })
    public ResponseEntity<?> exampleGetById(@PathVariable("code") String code) {
        log.info("######  ENTRADA A GET BY ID EXAMPLE |  CODE : " + code);
        ResponseEntity<?> response =null;
        CommentDTO responseData = this.commentService.getById(Long.parseLong(code));

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
    @ApiOperation(value = "Ejemplo de operación GET - ALL", response = CommentDTO.class, responseContainer = "List<>", notes = "Returns a List<ExampleDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success return a list of ExampleDTO object", response = CommentDTO.class ),
            @ApiResponse(code = 204, message = "No content, without content for the query", response = String.class ),
            @ApiResponse(code = 500, message = "Internal Server Error, Exception message")
    })
    public ResponseEntity<List<CommentDTO>> exampleGetAll() {
        log.info("######  ENTRADA A GET ALL EXAMPLE");
        ResponseEntity<List<CommentDTO>> response =null;
        List<CommentDTO> responseData = this.commentService.getAll();
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

    /**POST**/
    @PostMapping(value = "example", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "Ejemplo de operación POST", response = Boolean.class, responseContainer = "", notes = "Returns true for success and false for error operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success return a Boolean Object", response = Boolean.class ),
            @ApiResponse(code = 204, message = "No content, without content for the query"),
            @ApiResponse(code = 500, message = "Internal Server Error, Exception message")
    })
    public ResponseEntity<?> examplePost(@ApiParam(name = "requestIN", value = "List of ExampleDTO Object", required = true) @RequestBody List<CommentDTO> requestIN) {
        log.info("######  ENTRADA A POST EXAMPLE  | JSON REQUEST : "  +  new Gson().toJson(requestIN));

        ResponseEntity<?> response =null;
        boolean responseData = this.commentService.save(requestIN);
        try {
            if(responseData) {
                response =  new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
            }else {
                response = new ResponseEntity<>(Boolean.FALSE, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        log.info("######  SALIDA DE POST EXAMPLE");
        return response;
    }

    /**PUT**/
    @PutMapping(value = "example", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "Ejemplo de operación PUT", response = Boolean.class, responseContainer = "", notes = "Returns true for success and false for error operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success return a Boolean Object", response = Boolean.class ),
            @ApiResponse(code = 204, message = "No content, without content for the query"),
            @ApiResponse(code = 500, message = "Internal Server Error, Exception message")
    })
    public ResponseEntity<?> examplePut(@ApiParam(name = "request input", value = "String data", required = true) @RequestBody List<CommentDTO> requestIN) {
        log.info("######  ENTRADA A PUT EXAMPLE  | JSON REQUEST : "  +  new Gson().toJson(requestIN));

        ResponseEntity<?> response =null;
        boolean responseData = this.commentService.update(requestIN);
        try {
            if(responseData) {
                response =  new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(Boolean.FALSE, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("######  SALIDA DE PUT EXAMPLE");
        return response;
    }

    /**DELETE**/
    @DeleteMapping(value = "example/{code}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "Ejemplo de operación DELETE", response = Boolean.class, responseContainer = "", notes = "Returns a Boolean Message")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success return a Boolean Object", response = Boolean.class ),
            @ApiResponse(code = 204, message = "No content, without content for the query"),
            @ApiResponse(code = 500, message = "Internal Server Error, Exception message")
    })
    public ResponseEntity<?> exampleDelete(@PathVariable("code") String code) {
        log.info("######  ENTRADA A DELETE EXAMPLE  |  CODE : " + code);
        ResponseEntity<?> response =null;
        boolean responseData = this.commentService.delete(Long.parseLong(code));

        try {
            if(responseData) {
                response =  new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
            }else {
                response = new ResponseEntity<>(Boolean.FALSE, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("######  SALIDA DE DELETE EXAMPLE");
        return response;

    }
}

