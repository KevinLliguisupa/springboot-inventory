package com.inventory.crudinventory.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class CategoriaUpdateVO extends CategoriaVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
