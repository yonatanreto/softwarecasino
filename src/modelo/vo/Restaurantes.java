/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import com.nextic.filtercomponent.components.AbstractCodigo;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "restaurantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurantes.findAll", query = "SELECT r FROM Restaurantes r")
    , @NamedQuery(name = "Restaurantes.findById", query = "SELECT r FROM Restaurantes r WHERE r.id = :id")
    , @NamedQuery(name = "Restaurantes.findByNombre", query = "SELECT r FROM Restaurantes r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Restaurantes.findByNit", query = "SELECT r FROM Restaurantes r WHERE r.nit = :nit")})
public class Restaurantes implements Serializable,AbstractCodigo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "nit", nullable = false, length = 45)
    private String nit;

    public Restaurantes() {
    }

    public Restaurantes(Integer id) {
        this.id = id;
    }

    public Restaurantes(Integer id, String nombre, String nit) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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
        if (!(object instanceof Restaurantes)) {
            return false;
        }
        Restaurantes other = (Restaurantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.vo.Restaurantes[ id=" + id + " ]";
    }

    @Override
    public String getCodigo_abs() {
        return nit;
    }

    @Override
    public String getNombre_abs() {
        return this.nombre;
    }
    
}
