package com.inventory.crudinventory.DTO;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProductoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long proId;

    private String proNombre;

    private String proDescripcion;

    private CategoriaDTO categoria;

    private Boolean proIva;

    private BigDecimal proCosto;

    private BigDecimal proPvp;

    private String proImagen;

    private Boolean proEstado;

}
