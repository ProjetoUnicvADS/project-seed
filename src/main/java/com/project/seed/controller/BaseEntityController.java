package com.project.seed.controller;

import com.project.seed.model.BaseEntity;
import com.project.seed.model.dto.BaseEntityDto;
import com.project.seed.service.BaseEntityService;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Api(value = "Base Entities", tags = {"BaseEntity"})
public class BaseEntityController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BaseEntityService baseEntityService;

    @GetMapping("/baseEntities")
    @ApiOperation("Show all the base entities")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The base entities have been found successfully!"),
            @ApiResponse(code = 404, message = "No base entities was found!")
    })
    public ResponseEntity<List<BaseEntityDto>> list() {
        List<BaseEntityDto> listEntitiesDto = baseEntityService.list().stream()
                .map(entity -> modelMapper.map(entity, BaseEntityDto.class)).toList();

        return ResponseEntity.status(HttpStatus.OK).body(listEntitiesDto);
    }

    @GetMapping("baseEntity/{codEntity}")
    @ApiOperation("Show an base entity")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The base entity has been successfully found!"),
            @ApiResponse(code = 404, message = "The base entity cannot be found!")
    })
    public ResponseEntity<BaseEntityDto> getById(@PathVariable Integer codEntity) {
        Optional<BaseEntity> entity = baseEntityService.getById(codEntity);

        BaseEntityDto dtoFromEntity = modelMapper.map(entity, BaseEntityDto.class);

        return ResponseEntity.status(HttpStatus.OK).body(dtoFromEntity);

    }

    @PostMapping("baseEntity")
    @ApiOperation("Register an base entity")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The base entity has been successfully registered!"),
            @ApiResponse(code = 404, message = "The base entity could not be registered!")
    })
    public ResponseEntity<BaseEntityDto> save(@RequestBody BaseEntityDto entityDto) {

        BaseEntity entityFromDto = modelMapper.map(entityDto, BaseEntity.class);
        BaseEntity entity = baseEntityService.save(entityFromDto);

        BaseEntityDto dtoFromEntity = modelMapper.map(entity, BaseEntityDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(dtoFromEntity);
    }

    @PutMapping("baseEntity")
    @ApiOperation("Update an base entity")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The base entity has been successfully updated!"),
            @ApiResponse(code = 404, message = "The base entity could not be updated!")
    })
    public ResponseEntity<BaseEntityDto> update(@RequestBody Integer codEntity, @RequestBody BaseEntityDto entityDto) {

        BaseEntity entityFromDto = modelMapper.map(entityDto, BaseEntity.class);
        BaseEntity entity = baseEntityService.save(entityFromDto);

        BaseEntityDto dtoFromEntity = modelMapper.map(entity, BaseEntityDto.class);

        return ResponseEntity.status(HttpStatus.OK).body(dtoFromEntity);
    }

    @DeleteMapping("baseEntity/{codEntity}")
    @ApiOperation("Delete an base entity")
    public ResponseEntity<String> deleteById(@PathVariable Integer codEntity) {
        baseEntityService.deleteById(codEntity);

        return ResponseEntity.status(HttpStatus.OK).body("The base entity has been successfully removed!");
    }
}
