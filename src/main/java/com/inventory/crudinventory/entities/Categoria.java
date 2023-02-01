package com.inventory.crudinventory.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", nullable = false)
    private Long catId;

    @NotNull

    @Column(name = "cat_nombre", nullable = false)
    private String catNombre;

    @NotNull
    @Column(name = "cat_estado", nullable = false)
    private Boolean catEstado = false;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public Boolean getCatEstado() {
        return catEstado;
    }

    public void setCatEstado(Boolean catEstado) {
        this.catEstado = catEstado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}