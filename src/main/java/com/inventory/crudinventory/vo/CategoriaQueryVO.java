package com.inventory.crudinventory.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriaQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long catId;

    private String catNombre;

    private Boolean catEstado;

}
