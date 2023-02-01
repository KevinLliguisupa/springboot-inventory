package com.inventory.crudinventory.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class ProductoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "proId can not null")
    private Long proId;

    @NotNull(message = "proNombre can not null")
    private String proNombre;

    @NotNull(message = "proDescripcion can not null")
    private String proDescripcion;

    @NotNull(message = "catId can not null")
    private Long catId;

    @NotNull(message = "proIva can not null")
    private Boolean proIva;

    @NotNull(message = "proCosto can not null")
    private BigDecimal proCosto;

    @NotNull(message = "proPvp can not null")
    private BigDecimal proPvp;

    @NotNull(message = "proImagen can not null")
    private String proImagen;

    @NotNull(message = "proEstado can not null")
    private Boolean proEstado;

}
