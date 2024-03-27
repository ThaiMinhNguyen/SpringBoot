/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nemo.service.impl;

import com.nemo.converter.NewConverter;
import com.nemo.dto.NewDTO;
import com.nemo.entity.CategoryEntity;
import com.nemo.entity.NewEntity;
import com.nemo.repository.CategoryRepository;
import com.nemo.repository.NewRepository;
import com.nemo.service.INewService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public NewDTO save(NewDTO newDTO) {
        NewEntity newEntity = new NewEntity();
        if (newDTO.getId() != null) {
            NewEntity oldNewEntity = newRepository.findById(newDTO.getId()).orElseThrow();
            newEntity = newConverter.toEntity(newDTO, oldNewEntity);
            
        } else {
//            CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
            newEntity = newConverter.toEntity(newDTO);
            //chuyen qua phan converter 
//            newEntity.setCategory(categoryEntity);
            
            
        }
        newEntity = newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }

    @Override
    public void delete(long[] ids) {
        for(long i : ids){
            newRepository.deleteById(i);
        }
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> results = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
        for(NewEntity i : entities){
            NewDTO dto = newConverter.toDTO(i);
            results.add(dto);
        }
        return results;
    }
    
    @Override
    public List<NewDTO> findAll() {
        List<NewDTO> results = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll();
        for(NewEntity i : entities){
            NewDTO dto = newConverter.toDTO(i);
            results.add(dto);
        }
        return results;
    }
    
}
