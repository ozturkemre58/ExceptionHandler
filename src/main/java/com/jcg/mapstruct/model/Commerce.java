package com.jcg.mapstruct.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "commerces")
public class Commerce {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
    private String name;
      String nane;
     ArrayList<String> toDoList=new ArrayList<>();
}
