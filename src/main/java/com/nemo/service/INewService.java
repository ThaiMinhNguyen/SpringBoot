/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nemo.service;

import com.nemo.dto.NewDTO;
import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author admin
 */
public interface INewService {
	NewDTO save(NewDTO newDTO);
	void delete(long[] ids);
        public int totalItem();
        public List<NewDTO> findAll(Pageable pageable);
        public List<NewDTO> findAll();
}