package com.jcg.mapstruct.service;

import MyException.CommorceNotNullException;
import MyException.IllegalArgException;
import MyException.NotFoundException;
import com.jcg.mapstruct.model.Commerce;
import com.jcg.mapstruct.repository.CommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CommerceService {


    @Autowired
    CommerceRepository repository;

    public void save(Commerce commerce) {

        int sayac =0;

        if (commerce.getName().isEmpty() || commerce.getNane().isEmpty() || commerce.getToDoList().isEmpty()) {
            throw new CommorceNotNullException(("Commorce List name must be not null"));
        }
        else if (sayac+1== commerce.getId())
        {
            throw  new IllegalArgException(("Id number must be unique"));
        }
        else
        {repository.save(commerce);
        sayac++;}





    }

    public List<Commerce> findAll() {

        if (repository.findAll().isEmpty()) {
            throw new NotFoundException("Repository null");
        }

        return repository.findAll();
    }

    public Commerce findOne(int id) {

        return repository.findById(id).orElseThrow(() -> new NotFoundException("List Not Found"));
    }


    public Commerce updateListName(Commerce commerce) {

      return repository.save(commerce);

    }

    public Boolean deleteTask(int id) {
        Optional<Commerce> commerceOptional = Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("List Not Found")));
        if (commerceOptional.isPresent()) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}
