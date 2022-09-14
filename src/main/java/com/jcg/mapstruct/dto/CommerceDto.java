package com.jcg.mapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class CommerceDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String name;

     String nane;
     ArrayList<String> toDoList =new ArrayList<>();

}
