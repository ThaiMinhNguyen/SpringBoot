/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nemo.api;

/**
 *
 * @author admin
 */
import com.nemo.api.output.NewOutput;
import com.nemo.dto.NewDTO;
import com.nemo.service.INewService;
import com.nemo.service.impl.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class NewAPI {

    @Autowired
    private INewService newService;
    
    @GetMapping("/new")
    public NewOutput showNew(@RequestParam(value = "page", required = false) Integer page,
                   @RequestParam(value = "limit", required = false) Integer limit ){
        NewOutput result = new NewOutput();
        if(page != null && limit != null){
            result.setPage(page);
            Pageable pageable = PageRequest.of(page - 1, limit);
            result.setListResult(newService.findAll(pageable));
            result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
        } else {
            result.setListResult(newService.findAll());
        }
        return result;
    }

    @PostMapping("/new")
    public NewDTO createNew(@RequestBody NewDTO model) {
        return newService.save(model);
    }

    @PutMapping(value = "/new/{id}")
    public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return newService.save(model);
    }

    @DeleteMapping(value = "/new")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}
