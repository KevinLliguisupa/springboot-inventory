package com.inventory.crudinventory.DTO;


import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long catId;

    private String catNombre;

    private Boolean catEstado;

//    private List<ProductoDTO> productosList;

}
