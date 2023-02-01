package com.inventory.crudinventory.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id", nullable = false)
    private Long proId;

    @NotNull
    @Column(name = "pro_nombre", nullable = false)
    private String proNombre;

    @NotNull
    @Column(name = "pro_descripcion", nullable = false)
    private String proDescripcion;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "cat_id", nullable = false)
    @ToString.Exclude
    private Categoria categoria;

    @NotNull
    @Column(name = "pro_iva", nullable = false)
    private Boolean proIva = false;

    @NotNull
    @Column(name = "pro_costo", nullable = false, precision = 7, scale = 2)
    private BigDecimal proCosto;

    @NotNull
    @Column(name = "pro_pvp", nullable = false, precision = 7, scale = 2)
    private BigDecimal proPvp;

    @NotNull
    @Column(name = "pro_imagen", nullable = false)
    private String proImagen;

    @NotNull
    @Column(name = "pro_estado", nullable = false)
    private Boolean proEstado = false;

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Boolean getProIva() {
        return proIva;
    }

    public void setProIva(Boolean proIva) {
        this.proIva = proIva;
    }

    public BigDecimal getProCosto() {
        return proCosto;
    }

    public void setProCosto(BigDecimal proCosto) {
        this.proCosto = proCosto;
    }

    public BigDecimal getProPvp() {
        return proPvp;
    }

    public void setProPvp(BigDecimal proPvp) {
        this.proPvp = proPvp;
    }

    public String getProImagen() {
        return proImagen;
    }

    public void setProImagen(String proImagen) {
        this.proImagen = proImagen;
    }

    public Boolean getProEstado() {
        return proEstado;
    }

    public void setProEstado(Boolean proEstado) {
        this.proEstado = proEstado;
    }
}