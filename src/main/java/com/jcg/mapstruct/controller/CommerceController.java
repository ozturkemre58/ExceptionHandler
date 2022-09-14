package com.jcg.mapstruct.controller;


import com.jcg.mapstruct.dto.CommerceDto;
import com.jcg.mapstruct.mapper.CommerceMapper;
import com.jcg.mapstruct.model.Commerce;
import com.jcg.mapstruct.repository.CommerceRepository;
import com.jcg.mapstruct.service.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commerce")
public class CommerceController {

    @Autowired
    CommerceService service;

    @Autowired
    CommerceMapper mapper;

    @Autowired
    CommerceRepository repository;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CommerceDto> save(@RequestBody CommerceDto dto) {
        Commerce commerce = mapper.dtoToModel(dto);
        service.save(commerce);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<CommerceDto> findAll() {
        return mapper.modelsToDtos(service.findAll());
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommerceDto findOne(@PathVariable("id") int id) {
        return mapper.modelToDto(service.findOne(id));
    }

    @PutMapping("/uln")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CommerceDto> updateListName(@RequestBody CommerceDto commerceDto) {
        Commerce commerce = mapper.updateCommerceFromCommerceDto(commerceDto);
            service.save(commerce);
            return ResponseEntity.ok(commerceDto);
    }


    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> removeCommerce(@PathVariable int id) {
        Boolean status = service.deleteTask(id);
        return ResponseEntity.ok(status);
    }

}
