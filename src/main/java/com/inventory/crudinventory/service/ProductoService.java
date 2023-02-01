package com.inventory.crudinventory.service;

import com.inventory.crudinventory.DTO.CategoriaDTO;
import com.inventory.crudinventory.DTO.ProductoDTO;
import com.inventory.crudinventory.entities.Categoria;
import com.inventory.crudinventory.entities.Producto;
import com.inventory.crudinventory.repositories.CategoriaRepository;
import com.inventory.crudinventory.repositories.ProductoRepository;
import com.inventory.crudinventory.vo.ProductoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Page<ProductoDTO> getAllProductos(Integer page, Integer size, Boolean enablePagination){
        return toPageUserInfoDto(productoRepository.findAll(enablePagination ?
                PageRequest.of(page, size): Pageable.unpaged()));
    }

    public ProductoDTO getProductoById(Long idProducto){
        return toProductoDto(requireOne(idProducto));
    }

//    public Producto getProductoById(Long idProducto){
//        return requireOne(idProducto);
//    }

    public boolean existById(Long idProducto) {
        return productoRepository.existsById(idProducto);
    }

    public ProductoDTO createProducto(ProductoVO productoVo){
        if(productoVo.getProId() == null) {
            Producto producto = new Producto();
            BeanUtils.copyProperties(productoVo, producto);
            producto.setCategoria(categoriaRepository.findById(productoVo.getCatId())
                    .orElseThrow(() -> new NoSuchElementException("User id not found: " + productoVo.getCatId())));
            return toProductoDto(productoRepository.save(producto));
        }
        return null;
    }

    public ProductoDTO updateProducto(ProductoVO productoVo){
        if(productoVo.getProId() != null && productoRepository.existsById(productoVo.getProId())) {
            Producto producto = new Producto();
            BeanUtils.copyProperties(productoVo, producto);
            producto.setCategoria(categoriaRepository.findById(productoVo.getCatId())
                    .orElseThrow(() -> new NoSuchElementException("User id not found: " + productoVo.getCatId())));
            return toProductoDto(productoRepository.save(producto));
        }
        return null;
    }

    public void deleteProducto(Long idProducto){
        productoRepository.deleteById(idProducto);
    }

    public Page<ProductoDTO> toPageUserInfoDto(Page<Producto> original) {
        return original.map(this::toProductoDto);
    }

    private ProductoDTO toProductoDto(Producto producto){
        ProductoDTO bean = new ProductoDTO();
        BeanUtils.copyProperties(producto, bean);
        bean.setCategoria(toCategoriaDto(producto.getCategoria()));
        return bean;
    }

    private CategoriaDTO toCategoriaDto(Categoria categoria){
        CategoriaDTO bean = new CategoriaDTO();
        BeanUtils.copyProperties(categoria, bean);
        return bean;
    }

    private Producto requireOne(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User id not found: " + id));
    }

//    private CategoriaDTO toCategoriaDto(Categoria categoria){
//        CategoriaDTO bean = new CategoriaDTO();
//        BeanUtils.copyProperties(categoria, bean);
//        List<Producto> productos = categoria.getProductos();
//        List<ProductoDTO> productoDTOS = new ArrayList<ProductoDTO>();
//        for (Producto producto : productos) {
//            productoDTOS.add(toProductoDto(producto));
//        }
//        bean.setProductosList(productoDTOS);
//        return bean;
//    }

//    private Categoria requireOneCategoria(Long id) {
//        return categoriaRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("User id not found: " + id));
//    }
//    public CategoriaDTO getCategoriaById(Long idCategoria){
//        return toCategoriaDto(requireOneCategoria(idCategoria));
//    }
}
