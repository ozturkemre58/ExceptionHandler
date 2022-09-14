package com.jcg.mapstruct.mapper;

import com.jcg.mapstruct.dto.CommerceDto;
import com.jcg.mapstruct.model.Commerce;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CommerceMapper {

    CommerceMapper INSTANCE = Mappers.getMapper(CommerceMapper.class);


        // @Mapping(target = "refId", expression = "java(UUID.randomUUID().toString())")
    CommerceDto modelToDto(Commerce commerce);

    List<CommerceDto> modelsToDtos(List<Commerce> commerces);

    @InheritInverseConfiguration
    Commerce dtoToModel(CommerceDto commerceDto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Commerce updateCommerceFromCommerceDto(CommerceDto commerceDto);


}
