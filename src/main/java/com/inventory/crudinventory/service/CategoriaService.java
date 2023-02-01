package com.inventory.crudinventory.service;

import com.inventory.crudinventory.DTO.CategoriaDTO;
import com.inventory.crudinventory.entities.Categoria;
import com.inventory.crudinventory.repositories.CategoriaRepository;
import com.inventory.crudinventory.vo.CategoriaQueryVO;
import com.inventory.crudinventory.vo.CategoriaUpdateVO;
import com.inventory.crudinventory.vo.CategoriaVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Long save(CategoriaVO vO) {
        Categoria bean = new Categoria();
        BeanUtils.copyProperties(vO, bean);
        bean = categoriaRepository.save(bean);
        return bean.getCatId();
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    public void update(Long id, CategoriaUpdateVO vO) {
        Categoria bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        categoriaRepository.save(bean);
    }

    public CategoriaDTO getById(Long id) {
        Categoria original = requireOne(id);
        return toDTO(original);
    }

    public Page<CategoriaDTO> query(CategoriaQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CategoriaDTO toDTO(Categoria original) {
        CategoriaDTO bean = new CategoriaDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Categoria requireOne(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
