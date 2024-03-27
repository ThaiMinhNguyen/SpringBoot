/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nemo.repository;

import com.nemo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author admin
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
    CategoryEntity findOneByCode(String Code);
}
