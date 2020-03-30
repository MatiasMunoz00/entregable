/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.foroPesca_spring.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Addis Flerida Muñoz
 */
@Entity
@Table(name = "aguas")
@NamedQueries({
    @NamedQuery(name = "Aguas.findAll", query = "SELECT a FROM Aguas a")})
public class Aguas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Tipo")
    private String tipo;
    @Size(max = 255)
    @Column(name = "Nombre")
    private String nombre;
    @ManyToMany(mappedBy = "aguasList", fetch = FetchType.LAZY)
    private List<Region> regionList;
    @JoinTable(name = "peces_aguas", joinColumns = {
        @JoinColumn(name = "Id_Aguas", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_Peces", referencedColumnName = "Id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Peces> pecesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAguas", fetch = FetchType.LAZY)
    private List<Ubicacion> ubicacionList;

    public Aguas() {
    }

    public Aguas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<Region> regionList) {
        this.regionList = regionList;
    }

        public List<Peces> getPecesList() {
        return pecesList;
    }

    public void setPecesList(List<Peces> pecesList) {
        this.pecesList = pecesList;
    }

    public List<Ubicacion> getUbicacionList() {
        return ubicacionList;
    }

    public void setUbicacionList(List<Ubicacion> ubicacionList) {
        this.ubicacionList = ubicacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aguas)) {
            return false;
        }
        Aguas other = (Aguas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lp2.foroPesca_spring.modelo.Aguas[ id=" + id + " ]";
    }
    
}
