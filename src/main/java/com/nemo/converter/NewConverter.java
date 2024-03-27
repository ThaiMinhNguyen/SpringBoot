/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nemo.converter;

import com.nemo.dto.NewDTO;
import com.nemo.entity.CategoryEntity;
import com.nemo.entity.NewEntity;
import com.nemo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author admin
 */
@Component
public class NewConverter {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public NewEntity toEntity(NewDTO dto){
        NewEntity entity = new NewEntity();
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(dto.getCategoryCode());
        entity.setCategory(categoryEntity);
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescription());
        entity.setThumbnail(dto.getThumbnail());
        return entity;  
    }
    
    public NewDTO toDTO(NewEntity entity){
        NewDTO dto = new NewDTO();
        if(entity.getId()!=null){
            dto.setId(entity.getId());
        }
        dto.setCategoryCode(entity.getCategory().getCode());
        dto.setTitle(entity.getTitle());
        dto.setShortDescription(entity.getShortDescription());
        dto.setContent(entity.getContent());
        dto.setThumbnail(entity.getThumbnail());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;  
    }
    
    public NewEntity toEntity(NewDTO dto, NewEntity entity){
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(dto.getCategoryCode());
        entity.setCategory(categoryEntity);
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescription());
        entity.setThumbnail(dto.getThumbnail());
        return entity;  
    }
   
}
