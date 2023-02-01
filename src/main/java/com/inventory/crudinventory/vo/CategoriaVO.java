package com.inventory.crudinventory.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class CategoriaVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "catId can not null")
    private Long catId;

    @NotNull(message = "catNombre can not null")
    private String catNombre;

    @NotNull(message = "catEstado can not null")
    private Boolean catEstado;

}
