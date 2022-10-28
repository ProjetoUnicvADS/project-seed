package com.project.seed.controller;

import com.project.seed.model.BaseEntity;
import com.project.seed.service.BaseEntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Api(value = "Base Entities", tags = {"BaseEntity"}, description = " ")
public class BaseEntityController {

    @Autowired
    private BaseEntityService baseEntityService;

    @GetMapping("/baseEntities")
    @ApiOperation("Show all the base entities")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The base entities have been found successfully!"),
            @ApiResponse(code = 404, message = "No base entities was found!")
    })
    public ResponseEntity<List<BaseEntity>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(baseEntityService.list());
    }

    @GetMapping("baseEntity/{id}")
    @ApiOperation("Show an base entity")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The base entity has been successfully found!"),
            @ApiResponse(code = 404, message = "The base entity cannot be found!")
    })
    public ResponseEntity<Optional<BaseEntity>> getById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(baseEntityService.getById(id));
    }

    @PostMapping("baseEntity")
    @ApiOperation("Register an base entity")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The base entity has been successfully registered!"),
            @ApiResponse(code = 404, message = "The base entity could not be registered!")
    })
    public ResponseEntity<BaseEntity> save(@RequestBody BaseEntity baseEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(baseEntityService.save(baseEntity));
    }

    @PutMapping("baseEntity")
    @ApiOperation("Update an base entity")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The base entity has been successfully updated!"),
            @ApiResponse(code = 404, message = "The base entity could not be updated!")
    })
    public ResponseEntity<BaseEntity> update(@RequestBody BaseEntity baseEntity) {
        return ResponseEntity.status(HttpStatus.OK).body(baseEntityService.update(baseEntity));
    }

    @DeleteMapping("baseEntity/{id}")
    @ApiOperation("Delete an base entity")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        baseEntityService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("The base entity has been successfully removed!");
    }
}
