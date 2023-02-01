package com.inventory.crudinventory.controller;

import com.inventory.crudinventory.DTO.ProductoDTO;
import com.inventory.crudinventory.service.ProductoService;
import com.inventory.crudinventory.vo.ProductoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<Page<ProductoDTO>> getAllProductos(
            @RequestParam(required = false, defaultValue = "0")     Integer page,
            @RequestParam(required = false, defaultValue = "10")    Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enablePagination){

        return ResponseEntity.ok(productoService.getAllProductos(page, size, enablePagination));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductoDTO> findProductoById(@PathVariable ("id") Long idProducto){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.getProductoById(idProducto));
    }

    @PostMapping
    // @validated notation evaluates that the parameters are not blank
    public ResponseEntity<Object> createProducto(@Validated @RequestBody ProductoVO productoVo){
        ProductoDTO producto = productoService.createProducto(productoVo);
        if(producto != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(producto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Petición incorrecta");
    }

    @PutMapping
    public ResponseEntity<Object> updateProducto(@Validated @RequestBody ProductoVO productoVo){
        ProductoDTO producto = productoService.updateProducto(productoVo);
        if(producto != null){
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Petición incorrecta");
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProducto(@PathVariable ("id") Long idProducto){
        productoService.deleteProducto(idProducto);
        ResponseEntity.ok(!productoService.existById(idProducto));
    }


//    @GetMapping(value = "/categoria/{id}")
//    public ResponseEntity<CategoriaDTO> findCategoriaById(@PathVariable ("id") Long idCategoria){
//        return ResponseEntity.status(HttpStatus.OK).body(productoService.getCategoriaById(idCategoria));
//    }
}
